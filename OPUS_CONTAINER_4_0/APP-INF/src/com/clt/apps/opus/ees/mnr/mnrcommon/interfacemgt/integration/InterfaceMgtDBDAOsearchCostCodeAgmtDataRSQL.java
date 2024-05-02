/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InterfaceMgtDBDAOsearchCostCodeAgmtDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.02 
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

public class InterfaceMgtDBDAOsearchCostCodeAgmtDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public InterfaceMgtDBDAOsearchCostCodeAgmtDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cost_dtl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration").append("\n"); 
		query.append("FileName : InterfaceMgtDBDAOsearchCostCodeAgmtDataRSQL").append("\n"); 
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
		query.append("SELECT A.COST_CD, A.COST_DTL_CD" ).append("\n"); 
		query.append("  FROM MNR_AGMT_COST_DTL_CD A" ).append("\n"); 
		query.append(" WHERE (A.AGMT_OFC_CTY_CD, A.AGMT_SEQ) IN ( SELECT AGMT_OFC_CTY_CD, AGMT_SEQ" ).append("\n"); 
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