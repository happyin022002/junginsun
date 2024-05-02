/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RateMgtDBDAOsearchAgmtInfoDupDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RateMgtDBDAOsearchAgmtInfoDupDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public RateMgtDBDAOsearchAgmtInfoDupDataRSQL(){
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
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.integration").append("\n"); 
		query.append("FileName : RateMgtDBDAOsearchAgmtInfoDupDataRSQL").append("\n"); 
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
		query.append("SELECT AGMT_OFC_CTY_CD || LPAD(AGMT_SEQ, 6, 0) AS AGMT_NO" ).append("\n"); 
		query.append("  FROM MNR_AGMT_HDR" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("   AND EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("   AND CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append("   AND (( EFF_DT BETWEEN TO_DATE(@[eff_dt], 'YYYY-MM-DD') AND TO_DATE(@[exp_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("         OR EXP_DT BETWEEN TO_DATE(@[eff_dt], 'YYYY-MM-DD') AND TO_DATE(@[exp_dt], 'YYYY-MM-DD'))" ).append("\n"); 
		query.append("    OR (TO_DATE(@[eff_dt], 'YYYY-MM-DD') BETWEEN EFF_DT AND EXP_DT " ).append("\n"); 
		query.append("         OR TO_DATE(@[exp_dt], 'YYYY-MM-DD') BETWEEN EFF_DT AND EXP_DT))" ).append("\n"); 
		query.append("   AND AGMT_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("#if(${agmt_ofc_cty_cd} != '')" ).append("\n"); 
		query.append("   AND AGMT_OFC_CTY_CD||AGMT_SEQ <> @[agmt_ofc_cty_cd]||@[agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}