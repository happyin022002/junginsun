/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InterfaceMgtDBDAOsearchCostYardCodeDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceMgtDBDAOsearchCostYardCodeDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public InterfaceMgtDBDAOsearchCostYardCodeDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_dtl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rslt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration").append("\n"); 
		query.append("FileName : InterfaceMgtDBDAOsearchCostYardCodeDataRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT A.YD_CD" ).append("\n"); 
		query.append("  FROM MNR_AGMT_RT A," ).append("\n"); 
		query.append("(SELECT MNR_CD_ID, MNR_ORD_TP_CD" ).append("\n"); 
		query.append("  FROM MNR_GEN_CD" ).append("\n"); 
		query.append(" WHERE PRNT_CD_ID = @[eq_knd_cd]||'G') B" ).append("\n"); 
		query.append(" WHERE A.COST_CD = B.MNR_CD_ID" ).append("\n"); 
		query.append("   AND DECODE(B.MNR_ORD_TP_CD, 'TS', @[eq_tpsz_cd], @[cost_dtl_cd] ) = A.MNR_RT_TP_CD" ).append("\n"); 
		query.append("   AND (A.AGMT_OFC_CTY_CD, A.AGMT_SEQ, A.AGMT_VER_NO) IN ( SELECT AGMT_OFC_CTY_CD, AGMT_SEQ, AGMT_VER_NO" ).append("\n"); 
		query.append("                                              FROM MNR_AGMT_HDR" ).append("\n"); 
		query.append("                                             WHERE VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("                                               AND EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("                                               AND CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append("                                               AND TO_DATE(@[rpr_rslt_dt], 'YYYY-MM-DD') BETWEEN EFF_DT AND EXP_DT" ).append("\n"); 
		query.append("                                               AND AGMT_LST_VER_FLG = 'Y')" ).append("\n"); 
		query.append("   AND A.COST_CD = @[cost_cd]" ).append("\n"); 
		query.append("   AND A.COST_DTL_CD = @[cost_dtl_cd]" ).append("\n"); 

	}
}