/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChargeCalculationDBDAOBasicCurrencyCoverageVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.26
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2010.01.26 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwang HyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOBasicCurrencyCoverageVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ChargeCalculationDBDAOBasicCurrencyCoverageVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOBasicCurrencyCoverageVORSQL").append("\n"); 
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
		query.append("SELECT	 G.CURR_CD" ).append("\n"); 
		query.append(",DECODE( CVRG_YD_CD, ' '" ).append("\n"); 
		query.append(",DECODE(CVRG_LOC_CD, ' '" ).append("\n"); 
		query.append(",DECODE( NVL(CVRG_RGN_CD, CVRG_STE_CD), ' '" ).append("\n"); 
		query.append(",CVRG_CNT_CD" ).append("\n"); 
		query.append(",NVL(CVRG_RGN_CD, CVRG_STE_CD))" ).append("\n"); 
		query.append(",CVRG_LOC_CD)" ).append("\n"); 
		query.append(",CVRG_YD_CD" ).append("\n"); 
		query.append(") CVRG_CD" ).append("\n"); 
		query.append("FROM	DMT_TRF_RGN	R," ).append("\n"); 
		query.append("DMT_TRF_GRP	G" ).append("\n"); 
		query.append("WHERE	R.SYS_AREA_GRP_ID	= @[svr_id]" ).append("\n"); 
		query.append("AND		R.DMDT_TRF_CD		= @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND		R.TRF_SEQ			= @[trf_seq]" ).append("\n"); 
		query.append("AND		R.SYS_AREA_GRP_ID	= G.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND		R.DMDT_TRF_CD		= G.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND		R.TRF_SEQ			= G.TRF_SEQ" ).append("\n"); 
		query.append("AND		G.TRF_GRP_SEQ		= @[trf_grp_seq]" ).append("\n"); 

	}
}