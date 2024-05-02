/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : NetworkCostDBDAOSearchBunkerTariffCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.02
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2012.02.02 김종준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim jong jun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOSearchBunkerTariffCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BunkerTariff 존재유무 확인
	  * [CHM-201215754-01] [COA] Bunker Fee 화면 개발 건 조건 변경
	  * </pre>
	  */
	public NetworkCostDBDAOSearchBunkerTariffCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOSearchBunkerTariffCountRSQL").append("\n"); 
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
		query.append("SELECT B1.COST_YRMON" ).append("\n"); 
		query.append("  FROM COA_MON_VVD B1	" ).append("\n"); 
		query.append("	 , (	" ).append("\n"); 
		query.append("	   SELECT A1.VSL_SEQ         VSL_SEQ	" ).append("\n"); 
		query.append("			 ,A1.VSL_CD          VSL_CD	" ).append("\n"); 
		query.append("			 ,A1.VSL_TP_CD       VSL_TP_CD	" ).append("\n"); 
		query.append("			 ,A1.VSL_OSHP_CD     VSL_OSHP_CD	" ).append("\n"); 
		query.append("			 ,A1.VOP_CD          VOP_CD	" ).append("\n"); 
		query.append("			 ,A1.PORT_CLSS_CAPA  PORT_CLSS_CAPA	" ).append("\n"); 
		query.append("			 ,A1.VSL_CLSS_CAPA   VSL_CLSS_CAPA	" ).append("\n"); 
		query.append("			 ,A1.VSL_APLY_FM_DT  FM_DT	" ).append("\n"); 
		query.append("			 ,A1.VSL_APLY_TO_DT  TO_DT	" ).append("\n"); 
		query.append("		 FROM COA_VSL_RGST A1	" ).append("\n"); 
		query.append("		WHERE 1 = 1	" ).append("\n"); 
		query.append("		  AND NVL(A1.DELT_FLG, 'N') = 'N'	" ).append("\n"); 
		query.append("	 ) B2	" ).append("\n"); 
		query.append("	 , COA_LANE_RGST B3	" ).append("\n"); 
		query.append(" WHERE B1.VSL_CD           	= B2.VSL_CD	" ).append("\n"); 
		query.append("   AND B1.TRD_CD           	= B3.TRD_CD	" ).append("\n"); 
		query.append("   AND B1.RLANE_CD         	= B3.RLANE_CD	" ).append("\n"); 
		query.append("   AND B1.IOC_CD           	= B3.IOC_CD	" ).append("\n"); 
		query.append("   AND B1.DIR_CD           	= B3.DIR_CD	" ).append("\n"); 
		query.append("#if (${f_yrtype} == 'yrwk')	" ).append("\n"); 
		query.append("   AND B1.SLS_YRMON     	= @[cost_yrmon]	" ).append("\n"); 
		query.append("   AND B1.COST_WK       	= @[cost_wk]	" ).append("\n"); 
		query.append("#else	" ).append("\n"); 
		query.append("   AND B1.COST_YRMON      	= @[cost_yrmon]	" ).append("\n"); 
		query.append("   AND B1.COST_WK   		= @[cost_wk]	" ).append("\n"); 
		query.append("#end	" ).append("\n"); 
		query.append("   AND B1.DELT_FLG         	= 'N'	" ).append("\n"); 
		query.append("   AND NVL(B3.DELT_FLG,'N')	= 'N'" ).append("\n"); 
		query.append("   AND B2.VOP_CD           	= 'HJS'	" ).append("\n"); 
		query.append("   AND B3.TRD_CD           	<> 'COM'	" ).append("\n"); 
		query.append("   AND B3.VSL_LANE_TP_CD IN ('JO','SC')	" ).append("\n"); 
		query.append("   AND TO_CHAR(B1.N1ST_LODG_PORT_ETD_DT, 'YYYYMMDD')	" ).append("\n"); 
		query.append("	   BETWEEN NVL(TO_CHAR(B2.FM_DT, 'YYYYMMDD'), '19000101')	" ).append("\n"); 
		query.append("	   AND     NVL(TO_CHAR(B2.TO_DT, 'YYYYMMDD'), '99991231')	" ).append("\n"); 
		query.append("   AND B1.SLAN_CD       	= @[slan_cd]	" ).append("\n"); 
		query.append("   AND B1.RLANE_CD      	= @[rlane_cd]	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND B1.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("   AND B1.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND B1.DIR_CD = @[dir_cd]" ).append("\n"); 

	}
}