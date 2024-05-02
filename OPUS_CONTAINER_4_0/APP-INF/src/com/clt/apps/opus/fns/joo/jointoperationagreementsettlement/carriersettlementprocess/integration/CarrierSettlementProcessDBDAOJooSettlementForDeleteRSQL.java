/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOJooSettlementForDeleteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOJooSettlementForDeleteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 삭제할 Settlement의 PK를 조회한다.
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOJooSettlementForDeleteRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_mnu_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOJooSettlementForDeleteRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("       ACCT_YRMON" ).append("\n"); 
		query.append("      ,STL_VVD_SEQ" ).append("\n"); 
		query.append("      ,STL_SEQ" ).append("\n"); 
		query.append("      ,JO_CRR_CD" ).append("\n"); 
		query.append("      ,RE_DIVR_CD" ).append("\n"); 
		query.append("      ,TRD_CD" ).append("\n"); 
		query.append("      ,RLANE_CD" ).append("\n"); 
		query.append("      ,JO_STL_ITM_CD" ).append("\n"); 
		query.append("      ,JO_MNU_NM" ).append("\n"); 
		query.append("      ,RF_SCG_STL_TP_CD" ).append("\n"); 
		query.append("      ,IOC_CD" ).append("\n"); 
		query.append("      ,SCONTI_CD" ).append("\n"); 
		query.append("      ,FM_PORT_CD" ).append("\n"); 
		query.append("      ,TO_PORT_CD" ).append("\n"); 
		query.append("FROM  JOO_SETTLEMENT" ).append("\n"); 
		query.append("WHERE ACCT_YRMON    = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("AND	  JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("AND	  RE_DIVR_CD    = @[re_divr_cd]" ).append("\n"); 
		query.append("AND	  TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("AND	  RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("AND	  JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("AND   JO_MNU_NM     = @[jo_mnu_nm]" ).append("\n"); 
		query.append("#if (${sch_tp_cd} != '') " ).append("\n"); 
		query.append("	#if (${sch_tp_cd} == 'G') " ).append("\n"); 
		query.append("       AND   ST_DT IS NOT NULL " ).append("\n"); 
		query.append("       AND   END_DT IS NOT NULL" ).append("\n"); 
		query.append("       AND   SAIL_DYS IS NOT NULL" ).append("\n"); 
		query.append("	#elseif (${sch_tp_cd} == 'P') " ).append("\n"); 
		query.append("       AND   FM_PORT_CD IS NOT NULL " ).append("\n"); 
		query.append("       AND   TO_PORT_CD IS NOT NULL" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	   AND   SAIL_DYS IS NULL" ).append("\n"); 
		query.append("       AND   FM_PORT_CD IS NULL " ).append("\n"); 
		query.append("       AND   TO_PORT_CD IS NULL" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}