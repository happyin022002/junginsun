/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DVFactorMgtDBDAOsearchDVFactorListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.10.28 김완규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author WanGyu Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DVFactorMgtDBDAOsearchDVFactorListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public DVFactorMgtDBDAOsearchDVFactorListDataRSQL(){
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
		params.put("eq_dpc_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_dpc_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.integration").append("\n"); 
		query.append("FileName : DVFactorMgtDBDAOsearchDVFactorListDataRSQL").append("\n"); 
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
		query.append("SELECT A.EQ_DPC_YR," ).append("\n"); 
		query.append("A.EQ_TPSZ_CD  CD_ID," ).append("\n"); 
		query.append("A.EQ_KND_CD," ).append("\n"); 
		query.append("A.CURR_CD," ).append("\n"); 
		query.append("A.EQ_INIT_PRC," ).append("\n"); 
		query.append("A.EQ_DPC_RT," ).append("\n"); 
		query.append("A.EQ_MTRL_CD," ).append("\n"); 
		query.append("A.CRE_USR_ID," ).append("\n"); 
		query.append("A.CRE_DT," ).append("\n"); 
		query.append("A.UPD_USR_ID," ).append("\n"); 
		query.append("A.UPD_DT," ).append("\n"); 
		query.append("B.DESCRIPTION CD_DESC" ).append("\n"); 
		query.append("FROM MNR_EQ_DPC A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eq_knd_cd} == 'U')" ).append("\n"); 
		query.append("SELECT CNTR_TPSZ_CD    TBSZ_CD," ).append("\n"); 
		query.append("CNTR_TPSZ_DESC  DESCRIPTION" ).append("\n"); 
		query.append("FROM MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT EQ_TPSZ_CD    TBSZ_CD," ).append("\n"); 
		query.append("DIFF_DESC     DESCRIPTION" ).append("\n"); 
		query.append("FROM CGM_EQ_TP_SZ" ).append("\n"); 
		query.append("WHERE EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND A.EQ_TPSZ_CD = B.TBSZ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eq_dpc_yr} != '')" ).append("\n"); 
		query.append("AND A.EQ_DPC_YR = @[eq_dpc_yr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eq_dpc_rt} != '')" ).append("\n"); 
		query.append("AND A.EQ_DPC_RT = @[eq_dpc_rt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}