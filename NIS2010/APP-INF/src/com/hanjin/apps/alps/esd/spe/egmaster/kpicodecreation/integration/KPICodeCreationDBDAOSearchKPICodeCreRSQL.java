/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : KPICodeCreationDBDAOSearchKPICodeCreRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.26
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.26 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmaster.kpicodecreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KPICodeCreationDBDAOSearchKPICodeCreRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * KPI Code Creation 데이터를 조회한다
	  * </pre>
	  */
	public KPICodeCreationDBDAOSearchKPICodeCreRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ev_svc_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.egmaster.kpicodecreation.integration").append("\n"); 
		query.append("FileName : KPICodeCreationDBDAOSearchKPICodeCreRSQL").append("\n"); 
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
		query.append("SELECT SP_KPI_ID" ).append("\n"); 
		query.append("     , EV_SVC_CATE_CD" ).append("\n"); 
		query.append("     , EV_SVC_CATE_CD AS EV_SVC_CATE_CODE" ).append("\n"); 
		query.append("     , SP_KPI_NM" ).append("\n"); 
		query.append("     , SP_KPI_DESC" ).append("\n"); 
		query.append("     , SP_KPI_TP_CD" ).append("\n"); 
		query.append("     , DELT_FLG" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , TO_CHAR(CRE_DT, 'YYYY.MM.DD') AS CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , TO_CHAR(UPD_DT, 'YYYY.MM.DD') AS UPD_DT" ).append("\n"); 
		query.append("  FROM SPE_SP_SVC_CATE_KPI" ).append("\n"); 
		query.append(" WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if(${s_ev_svc_cate_cd}!='')" ).append("\n"); 
		query.append("   AND EV_SVC_CATE_CD = @[s_ev_svc_cate_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY EV_SVC_CATE_CD,SP_KPI_ID" ).append("\n"); 

	}
}