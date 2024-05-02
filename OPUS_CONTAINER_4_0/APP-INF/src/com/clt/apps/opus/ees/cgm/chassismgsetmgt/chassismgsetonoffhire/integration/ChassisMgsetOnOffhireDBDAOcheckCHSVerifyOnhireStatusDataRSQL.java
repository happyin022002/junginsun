/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOcheckCHSVerifyOnhireStatusDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.26
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.03.26 조재성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetOnOffhireDBDAOcheckCHSVerifyOnhireStatusDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOcheckCHSVerifyOnhireStatusDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agreement_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_als_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n2nd_chss_als_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_tit_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_veh_id_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("onh_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOcheckCHSVerifyOnhireStatusDataRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN" ).append("\n"); 
		query.append("exists (select 'X' from" ).append("\n"); 
		query.append("CGM_EQUIPMENT A" ).append("\n"); 
		query.append("WHERE A.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("and A.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append(") THEN" ).append("\n"); 
		query.append("'Failed(Active Chassis)'" ).append("\n"); 
		query.append("WHEN" ).append("\n"); 
		query.append("exists (select 'X' from" ).append("\n"); 
		query.append("CGM_EQUIPMENT A" ).append("\n"); 
		query.append("WHERE A.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = 'G'" ).append("\n"); 
		query.append(") THEN" ).append("\n"); 
		query.append("'Already exists in M.G.Set'" ).append("\n"); 
		query.append("-- OWN, LEASED" ).append("\n"); 
		query.append("#if (${own_lse} == 'O')" ).append("\n"); 
		query.append("WHEN" ).append("\n"); 
		query.append("exists (select 'X' from" ).append("\n"); 
		query.append("CGM_EQUIPMENT A" ).append("\n"); 
		query.append("WHERE A.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("and A.AGMT_LSTM_CD NOT IN ('OW', 'OL', 'LP')" ).append("\n"); 
		query.append(") THEN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("'Failed(Own Chassis)'" ).append("\n"); 
		query.append("#if(${eq_tpsz_cd} != '')" ).append("\n"); 
		query.append("WHEN" ).append("\n"); 
		query.append("exists (select 'X' from" ).append("\n"); 
		query.append("CGM_EQUIPMENT A" ).append("\n"); 
		query.append("WHERE A.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("and A.EQ_TPSZ_CD != @[eq_tpsz_cd]" ).append("\n"); 
		query.append(") THEN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("'Failed(Type/Size unmatched)'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("WHEN" ).append("\n"); 
		query.append("exists (select 'X' from" ).append("\n"); 
		query.append("CGM_EQUIPMENT A" ).append("\n"); 
		query.append("WHERE A.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("and A.AGMT_LSTM_CD IN ('OW', 'OL', 'LP')" ).append("\n"); 
		query.append(") THEN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("'Failed(Leased Chassis)'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHEN" ).append("\n"); 
		query.append("exists (select 'X' from CGM_EQUIPMENT A,CGM_EQ_STS_HIS B" ).append("\n"); 
		query.append("WHERE A.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("AND A.EQ_NO = B.EQ_NO(+)" ).append("\n"); 
		query.append("AND A.EQ_STS_SEQ = B.EQ_STS_SEQ(+)" ).append("\n"); 
		query.append("AND B.EQ_ASET_STS_CD IN ('LST')" ).append("\n"); 
		query.append(") THEN" ).append("\n"); 
		query.append("'Failed(LST Status)'" ).append("\n"); 
		query.append("-- CHSS_VEH_ID_NO" ).append("\n"); 
		query.append("WHEN exists (SELECT 'X' FROM CGM_EQUIPMENT A" ).append("\n"); 
		query.append("WHERE A.CHSS_VEH_ID_NO = @[chss_veh_id_no]" ).append("\n"); 
		query.append("AND A.EQ_NO          <> @[eq_no]" ).append("\n"); 
		query.append("AND A.CHSS_VEH_ID_NO IS NOT NULL" ).append("\n"); 
		query.append(")  THEN" ).append("\n"); 
		query.append("'Failed(Already VIN No. Exists!)'" ).append("\n"); 
		query.append("-- CHSS_TIT_NO" ).append("\n"); 
		query.append("WHEN EXISTS (SELECT 'X' FROM CGM_EQUIPMENT A" ).append("\n"); 
		query.append("WHERE A.CHSS_TIT_NO = @[chss_tit_no]" ).append("\n"); 
		query.append("AND A.EQ_NO          <> @[eq_no]" ).append("\n"); 
		query.append("AND A.CHSS_TIT_NO IS NOT NULL" ).append("\n"); 
		query.append(") THEN" ).append("\n"); 
		query.append("'Failed(Already Title No. Exists!)'" ).append("\n"); 
		query.append("-- CHSS_ALS_ON" ).append("\n"); 
		query.append("WHEN EXISTS (SELECT 'X' FROM CGM_EQUIPMENT A" ).append("\n"); 
		query.append("WHERE (A.CHSS_ALS_NO = @[chss_als_no]" ).append("\n"); 
		query.append("OR A.N2ND_CHSS_ALS_NO = @[chss_als_no] )" ).append("\n"); 
		query.append("AND A.EQ_NO          <> @[eq_no]" ).append("\n"); 
		query.append("AND A.CHSS_ALS_NO IS NOT NULL" ).append("\n"); 
		query.append(")  THEN" ).append("\n"); 
		query.append("'Failed(Already Alias No. Exists!)'" ).append("\n"); 
		query.append("-- N2ND_CHSS_ALS_NO" ).append("\n"); 
		query.append("WHEN EXISTS (SELECT 'X' FROM CGM_EQUIPMENT A" ).append("\n"); 
		query.append("WHERE (A.CHSS_ALS_NO = @[n2nd_chss_als_no]" ).append("\n"); 
		query.append("OR A.N2ND_CHSS_ALS_NO = @[n2nd_chss_als_no] )" ).append("\n"); 
		query.append("AND A.EQ_NO          <> @[eq_no]" ).append("\n"); 
		query.append("AND A.CHSS_ALS_NO IS NOT NULL" ).append("\n"); 
		query.append(")  THEN" ).append("\n"); 
		query.append("'Failed(Already 2nd Alias No. Exists!)'" ).append("\n"); 
		query.append("WHEN EXISTS (SELECT 'X' from DUAL" ).append("\n"); 
		query.append("WHERE  TO_DATE(@[onh_dt], 'YYYY-MM-DD HH24:MI') < (select B.STS_EVNT_DT  from CGM_EQUIPMENT A,CGM_EQ_STS_HIS B" ).append("\n"); 
		query.append("WHERE A.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("AND A.EQ_NO = B.EQ_NO(+)" ).append("\n"); 
		query.append("AND A.EQ_STS_SEQ = B.EQ_STS_SEQ(+)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")  THEN" ).append("\n"); 
		query.append("'Check off-hire Time.'" ).append("\n"); 
		query.append("WHEN NOT EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("FROM CGM_AGREEMENT A" ).append("\n"); 
		query.append("WHERE A.AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("AND A.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND TO_DATE(@[onh_dt], 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("BETWEEN A.EFF_DT AND A.EXP_DT" ).append("\n"); 
		query.append(")  THEN" ).append("\n"); 
		query.append("'Please check up the Agreement Effective Date .'" ).append("\n"); 
		query.append("-- OWN, LEASED" ).append("\n"); 
		query.append("#if (${own_lse} != 'O')" ).append("\n"); 
		query.append("WHEN NOT EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("FROM CGM_AGREEMENT A, CGM_AGMT_LSE_RT B, CGM_AGMT_LSE_TR_RT C" ).append("\n"); 
		query.append("WHERE A.AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("AND A.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("AND TO_DATE(@[onh_dt], 'YYYY-MM-DD HH24:MI') BETWEEN A.EFF_DT AND A.EXP_DT" ).append("\n"); 
		query.append("AND A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND A.AGMT_SEQ = B.AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND A.AGMT_VER_NO = B.AGMT_VER_NO(+)" ).append("\n"); 
		query.append("AND A.AGMT_OFC_CTY_CD = C.AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND A.AGMT_SEQ = C.AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND A.AGMT_VER_NO = C.AGMT_VER_NO(+)" ).append("\n"); 
		query.append("AND DECODE(A.EQ_RNTL_TP_CD, 'F', B.EQ_TPSZ_CD, C.EQ_TPSZ_CD) = @[eq_tpsz_cd]" ).append("\n"); 
		query.append("AND DECODE(A.EQ_RNTL_TP_CD, 'F', B.CHSS_LSE_RT_AMT, C.TR_RT_AMT) > 0" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(")  THEN" ).append("\n"); 
		query.append("'Inputted Agreement ['|| @[agreement_no] ||'] has no Rental Rate for the Chassis/M.G.Set Type/Size ['||@[eq_tpsz_cd] ||'] ! '" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${own_lse} != 'O')" ).append("\n"); 
		query.append("WHEN  EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("FROM CGM_LSE_CHG_HDR A" ).append("\n"); 
		query.append("WHERE A.AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("AND A.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("AND A.COST_YRMON = TO_CHAR(TO_DATE(@[onh_dt], 'YYYY-MM-DD HH24:MI:SS'),'YYYYMM' )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")  THEN" ).append("\n"); 
		query.append("'Inputted On-Hire Month has Charge-Creation History. Please check the On-Hire Date again /or/ cancel the Charge-Creation History if necessary. '" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("'OK'" ).append("\n"); 
		query.append("END AS VERIFY" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}