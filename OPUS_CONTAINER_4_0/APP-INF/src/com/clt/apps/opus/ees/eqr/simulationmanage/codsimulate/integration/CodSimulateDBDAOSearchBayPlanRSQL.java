/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodSimulateDBDAOSearchBayPlanRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.10
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.12.10 채창호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodSimulateDBDAOSearchBayPlanRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OPF_BAY_PLN_LDIS에서 Bay Plan 정보 검색
	  * </pre>
	  */
	public CodSimulateDBDAOSearchBayPlanRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_port",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.integration").append("\n"); 
		query.append("FileName : CodSimulateDBDAOSearchBayPlanRSQL").append("\n"); 
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
		query.append("SELECT	BAY.VSL_CD||BAY.SKD_VOY_NO||BAY.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append(",BAY.POL_CD AS POL" ).append("\n"); 
		query.append(",BAY.POD_CD AS POD" ).append("\n"); 
		query.append(",COUNT(BAY.CNTR_TPSZ_CD) AS TOTAL" ).append("\n"); 
		query.append("#foreach( ${key} in ${arrtpszcd})" ).append("\n"); 
		query.append("#if (${key} == 'O2')" ).append("\n"); 
		query.append(",COUNT(DECODE(BAY.CNTR_TPSZ_CD,'O2', CLPT_IND_SEQ))" ).append("\n"); 
		query.append("+ COUNT(DECODE(BAY.CNTR_TPSZ_CD,'S2', CLPT_IND_SEQ)) AS TPSZO2" ).append("\n"); 
		query.append("#elseif (${key} == 'O4')" ).append("\n"); 
		query.append(",COUNT(DECODE(BAY.CNTR_TPSZ_CD,'O4', CLPT_IND_SEQ))" ).append("\n"); 
		query.append("+ COUNT(DECODE(BAY.CNTR_TPSZ_CD,'S4', CLPT_IND_SEQ)) AS TPSZO4" ).append("\n"); 
		query.append("#elseif (${key} == 'F2')" ).append("\n"); 
		query.append(",COUNT(DECODE(BAY.CNTR_TPSZ_CD,'F2', CLPT_IND_SEQ))" ).append("\n"); 
		query.append("+ COUNT(DECODE(BAY.CNTR_TPSZ_CD,'A2', CLPT_IND_SEQ)) AS TPSZF2" ).append("\n"); 
		query.append("#elseif (${key} == 'F4')" ).append("\n"); 
		query.append(",COUNT(DECODE(BAY.CNTR_TPSZ_CD,'F4', CLPT_IND_SEQ))" ).append("\n"); 
		query.append("+ COUNT(DECODE(BAY.CNTR_TPSZ_CD,'A4', CLPT_IND_SEQ))" ).append("\n"); 
		query.append("+ COUNT(DECODE(BAY.CNTR_TPSZ_CD,'F5', CLPT_IND_SEQ)) AS TPSZF4" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",COUNT(DECODE(BAY.CNTR_TPSZ_CD,'$key', CLPT_IND_SEQ)) AS TPSZ${key}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM	OPF_BAY_PLN_LDIS BAY, MST_CONTAINER CNTR" ).append("\n"); 
		query.append("WHERE	BAY.CNTR_REF_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("AND	BAY.VSL_CD				= @[vsl_cd]" ).append("\n"); 
		query.append("AND	BAY.SKD_VOY_NO			= @[skd_voy_no]" ).append("\n"); 
		query.append("AND	BAY.SKD_DIR_CD			= @[skd_dir_cd]" ).append("\n"); 
		query.append("AND	BAY.VPS_PORT_CD			= @[search_port]" ).append("\n"); 
		query.append("AND	BAY.FULL_MTY_CD         = 'E'" ).append("\n"); 
		query.append("-- AND	BAY.LODG_DCHG_IND_CD    in ('C','L')" ).append("\n"); 
		query.append("AND   BAY.LODG_DCHG_IND_CD = 'C'" ).append("\n"); 
		query.append("AND	CNTR.LSTM_CD	        <> 'SH'" ).append("\n"); 
		query.append("GROUP BY BAY.VSL_CD||BAY.SKD_VOY_NO||BAY.SKD_DIR_CD, BAY.POL_CD, BAY.POD_CD" ).append("\n"); 
		query.append("ORDER BY 1,2,3" ).append("\n"); 

	}
}