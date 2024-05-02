/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOsearchCHSEqPoolInfoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.21
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.12.21 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetOnOffhireDBDAOsearchCHSEqPoolInfoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOsearchCHSEqPoolInfoDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_pool_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aciac_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOsearchCHSEqPoolInfoDataRSQL").append("\n"); 
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
		query.append("SELECT A.EQ_NO," ).append("\n"); 
		query.append("A.EQ_TPSZ_CD," ).append("\n"); 
		query.append("A.CRNT_YD_CD," ).append("\n"); 
		query.append("A.ACIAC_DIV_CD," ).append("\n"); 
		query.append("A.CHSS_POOL_CD," ).append("\n"); 
		query.append("A.CRNT_LOC_CD," ).append("\n"); 
		query.append("A.EQ_KND_CD," ).append("\n"); 
		query.append("A.CHSS_RGST_UPD_OFC_CD," ).append("\n"); 
		query.append("A.CHSS_RGST_UPD_ID," ).append("\n"); 
		query.append("TO_CHAR(A.CHSS_RGST_UPD_DT, 'yyyy-MM-dd') AS CHSS_RGST_UPD_DT" ).append("\n"); 
		query.append("FROM CGM_EQUIPMENT A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("#if (${eq_no} != '')" ).append("\n"); 
		query.append("AND A.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${chss_pool_cd} != '')" ).append("\n"); 
		query.append("AND A.CHSS_POOL_CD = @[chss_pool_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scc_cd} != '')" ).append("\n"); 
		query.append("AND A.CRNT_LOC_CD IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.LOC_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION A," ).append("\n"); 
		query.append("MDM_EQ_ORZ_CHT B" ).append("\n"); 
		query.append("WHERE A.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${location} == 'R')" ).append("\n"); 
		query.append("AND B.RCC_CD IN (${scc_cd})" ).append("\n"); 
		query.append("#elseif (${location} == 'L')" ).append("\n"); 
		query.append("AND B.LCC_CD IN (${scc_cd})" ).append("\n"); 
		query.append("#elseif (${location} == 'S')" ).append("\n"); 
		query.append("AND B.SCC_CD IN (${scc_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${crnt_yd_cd} != '')" ).append("\n"); 
		query.append("AND A.CRNT_YD_CD IN ($crnt_yd_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${aciac_div_cd} != '')" ).append("\n"); 
		query.append("AND A.ACIAC_DIV_CD = @[aciac_div_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND A.AGMT_LSTM_CD  <> 'NP'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.EQ_NO" ).append("\n"); 

	}
}