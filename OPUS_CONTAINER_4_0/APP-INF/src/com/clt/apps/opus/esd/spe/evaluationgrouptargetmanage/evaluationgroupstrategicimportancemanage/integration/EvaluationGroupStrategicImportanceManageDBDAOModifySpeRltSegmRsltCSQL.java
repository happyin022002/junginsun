/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EvaluationGroupStrategicImportanceManageDBDAOModifySpeRltSegmRsltCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.02.01 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupstrategicimportancemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EvaluationGroupStrategicImportanceManageDBDAOModifySpeRltSegmRsltCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EvaluationGroupStrategicImportanceManageDBDAOMultiSPE_EV_GRP_STRG_IMPT_RSLT SQL 실행이 완료되면,  
	  * SRS Analysis는 SI Analysis와 RA Analysis 의 결과값을 match 하여 생성하는 Analysis 이므로SRS Analysis Result 테이블에 
	  * merge into 를 사용하여 SI Analysis 변경사항을 적용한다.
	  * </pre>
	  */
	public EvaluationGroupStrategicImportanceManageDBDAOModifySpeRltSegmRsltCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("si_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eg_id_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("si_grp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ds_scre",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ev_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bi_scre",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("SI_GRP_CD",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupstrategicimportancemanage.integration ").append("\n"); 
		query.append("FileName : EvaluationGroupStrategicImportanceManageDBDAOModifySpeRltSegmRsltCSQL").append("\n"); 
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
		query.append("MERGE INTO SPE_RLT_SEGM_RSLT A" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("SELECT A.VNDR_SEQ ," ).append("\n"); 
		query.append("@[ev_yr] EV_YR ," ).append("\n"); 
		query.append("B.RA_GRP_CD ," ).append("\n"); 
		query.append("ROUND( CASE WHEN @[si_grp_cd]  = 'CR' THEN SQRT(((TO_NUMBER(@[bi_scre]) - 2.5) * (TO_NUMBER(@[bi_scre]) - 2.5)) + ((TO_NUMBER(@[ds_scre]) - 2.5) * (TO_NUMBER(@[ds_scre]) - 2.5)))" ).append("\n"); 
		query.append("WHEN @[si_grp_cd] = 'LV' THEN SQRT(((TO_NUMBER(@[bi_scre]) - 2.5) * (TO_NUMBER(@[bi_scre]) - 2.5)) + (TO_NUMBER(@[ds_scre]) * TO_NUMBER(@[ds_scre])))" ).append("\n"); 
		query.append("WHEN @[si_grp_cd] = 'BN' THEN SQRT((TO_NUMBER(@[bi_scre]) * TO_NUMBER(@[bi_scre]) ) + ((TO_NUMBER(@[ds_scre]) - 2.5) * (TO_NUMBER(@[ds_scre]) - 2.5)))" ).append("\n"); 
		query.append("WHEN @[si_grp_cd] = 'RT' THEN SQRT((TO_NUMBER(@[bi_scre]) * TO_NUMBER(@[bi_scre])) + (TO_NUMBER(@[ds_scre]) * TO_NUMBER(@[ds_scre]))) END , 2) SI_SCRE ," ).append("\n"); 
		query.append("B.RA_SCRE ," ).append("\n"); 
		query.append("ROUND( CASE WHEN B.RA_GRP_CD = 'HM' THEN (TO_NUMBER(B.RA_SCRE) + (2.5 * 3 ))" ).append("\n"); 
		query.append("WHEN B.RA_GRP_CD = 'EX' THEN (TO_NUMBER(B.RA_SCRE) + (2.5 * 2 ))" ).append("\n"); 
		query.append("WHEN B.RA_GRP_CD = 'DV' THEN (TO_NUMBER(B.RA_SCRE) + (2.5 * 1 ))" ).append("\n"); 
		query.append("WHEN B.RA_GRP_CD = 'LM' THEN (TO_NUMBER(B.RA_SCRE) + (2.5 * 0 ))" ).append("\n"); 
		query.append("END , 2) MODI_RA_SCRE ," ).append("\n"); 
		query.append("@[si_grp_cd] SI_GRP_CD ," ).append("\n"); 
		query.append("@[si_grp_nm] SI_GRP_NM" ).append("\n"); 
		query.append("FROM SPE_EV_GRP_SVC_PROV_MTCH A ," ).append("\n"); 
		query.append("SPE_RLT_ATRC_RSLT B" ).append("\n"); 
		query.append("WHERE A.EG_ID       = @[eg_id]" ).append("\n"); 
		query.append("AND A.EG_ID_SEQ   = @[eg_id_seq]" ).append("\n"); 
		query.append("AND A.VNDR_SEQ    = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND @[ev_yr]      = B.EV_YR(+) ) B" ).append("\n"); 
		query.append("ON (A.VNDR_SEQ  = B.VNDR_SEQ" ).append("\n"); 
		query.append("AND A.EV_YR     = B.EV_YR)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET SI_SCRE = B.SI_SCRE ," ).append("\n"); 
		query.append("MODI_SI_SCRE = ROUND( CASE WHEN @[SI_GRP_CD] = 'CR' THEN (B.SI_SCRE + (2.5 * 3 ))" ).append("\n"); 
		query.append("WHEN @[SI_GRP_CD] = 'LV' THEN (B.SI_SCRE + (2.5 * 1 ))" ).append("\n"); 
		query.append("WHEN @[SI_GRP_CD] = 'BN' THEN (B.SI_SCRE + (2.5 * 2 ))" ).append("\n"); 
		query.append("WHEN @[SI_GRP_CD] = 'RT' THEN (B.SI_SCRE + (2.5 * 0 )) END , 2) ," ).append("\n"); 
		query.append("RA_SCRE = B.RA_SCRE ," ).append("\n"); 
		query.append("MODI_RA_SCRE = B.MODI_RA_SCRE ," ).append("\n"); 
		query.append("SRS_GRP_CD = CASE WHEN (@[SI_GRP_CD] = 'CR' AND B.RA_GRP_CD = 'LM') THEN 'G1'" ).append("\n"); 
		query.append("WHEN (@[SI_GRP_CD] = 'CR' AND B.RA_GRP_CD = 'EX') THEN 'C1'" ).append("\n"); 
		query.append("WHEN (@[SI_GRP_CD] = 'CR' AND B.RA_GRP_CD = 'DV') THEN 'C2'" ).append("\n"); 
		query.append("WHEN (@[SI_GRP_CD] = 'CR' AND B.RA_GRP_CD = 'HM') THEN 'ST'" ).append("\n"); 
		query.append("WHEN (@[SI_GRP_CD] = 'BN' AND B.RA_GRP_CD = 'LM') THEN 'TA'" ).append("\n"); 
		query.append("WHEN (@[SI_GRP_CD] = 'BN' AND B.RA_GRP_CD = 'EX') THEN 'TA'" ).append("\n"); 
		query.append("WHEN (@[SI_GRP_CD] = 'BN' AND B.RA_GRP_CD = 'DV') THEN 'C3'" ).append("\n"); 
		query.append("WHEN (@[SI_GRP_CD] = 'BN' AND B.RA_GRP_CD = 'HM') THEN 'C4'" ).append("\n"); 
		query.append("WHEN (@[SI_GRP_CD] = 'LV' AND B.RA_GRP_CD = 'LM') THEN 'TA'" ).append("\n"); 
		query.append("WHEN (@[SI_GRP_CD] = 'LV' AND B.RA_GRP_CD = 'EX') THEN 'TA'" ).append("\n"); 
		query.append("WHEN (@[SI_GRP_CD] = 'LV' AND B.RA_GRP_CD = 'DV') THEN 'TA'" ).append("\n"); 
		query.append("WHEN (@[SI_GRP_CD] = 'LV' AND B.RA_GRP_CD = 'HM') THEN 'C5'" ).append("\n"); 
		query.append("WHEN (@[SI_GRP_CD] = 'RT' AND B.RA_GRP_CD = 'LM') THEN 'TA'" ).append("\n"); 
		query.append("WHEN (@[SI_GRP_CD] = 'RT' AND B.RA_GRP_CD = 'EX') THEN 'TA'" ).append("\n"); 
		query.append("WHEN (@[SI_GRP_CD] = 'RT' AND B.RA_GRP_CD = 'DV') THEN 'TA'" ).append("\n"); 
		query.append("WHEN (@[SI_GRP_CD] = 'RT' AND B.RA_GRP_CD = 'HM') THEN 'G2'" ).append("\n"); 
		query.append("END ," ).append("\n"); 
		query.append("SRS_GRP_NM = CASE WHEN (@[SI_GRP_CD] = 'CR' AND B.RA_GRP_CD = 'LM') THEN 'GRAY'" ).append("\n"); 
		query.append("WHEN (@[SI_GRP_CD] = 'CR' AND B.RA_GRP_CD = 'EX') THEN 'COLLABORATIVE'" ).append("\n"); 
		query.append("WHEN (@[SI_GRP_CD] = 'CR' AND B.RA_GRP_CD = 'DV') THEN 'COLLABORATIVE'" ).append("\n"); 
		query.append("WHEN (@[SI_GRP_CD] = 'CR' AND B.RA_GRP_CD = 'HM') THEN 'STRATEGIC'" ).append("\n"); 
		query.append("WHEN (@[SI_GRP_CD] = 'BN' AND B.RA_GRP_CD = 'LM') THEN 'TRANSACTIONAL'" ).append("\n"); 
		query.append("WHEN (@[SI_GRP_CD] = 'BN' AND B.RA_GRP_CD = 'EX') THEN 'TRANSACTIONAL'" ).append("\n"); 
		query.append("WHEN (@[SI_GRP_CD] = 'BN' AND B.RA_GRP_CD = 'DV') THEN 'COLLABORATIVE'" ).append("\n"); 
		query.append("WHEN (@[SI_GRP_CD] = 'BN' AND B.RA_GRP_CD = 'HM') THEN 'COLLABORATIVE'" ).append("\n"); 
		query.append("WHEN (@[SI_GRP_CD] = 'LV' AND B.RA_GRP_CD = 'LM') THEN 'TRANSACTIONAL'" ).append("\n"); 
		query.append("WHEN (@[SI_GRP_CD] = 'LV' AND B.RA_GRP_CD = 'EX') THEN 'TRANSACTIONAL'" ).append("\n"); 
		query.append("WHEN (@[SI_GRP_CD] = 'LV' AND B.RA_GRP_CD = 'DV') THEN 'TRANSACTIONAL'" ).append("\n"); 
		query.append("WHEN (@[SI_GRP_CD] = 'LV' AND B.RA_GRP_CD = 'HM') THEN 'COLLABORATIVE'" ).append("\n"); 
		query.append("WHEN (@[SI_GRP_CD] = 'RT' AND B.RA_GRP_CD = 'LM') THEN 'TRANSACTIONAL'" ).append("\n"); 
		query.append("WHEN (@[SI_GRP_CD] = 'RT' AND B.RA_GRP_CD = 'EX') THEN 'TRANSACTIONAL'" ).append("\n"); 
		query.append("WHEN (@[SI_GRP_CD] = 'RT' AND B.RA_GRP_CD = 'DV') THEN 'TRANSACTIONAL'" ).append("\n"); 
		query.append("WHEN (@[SI_GRP_CD] = 'RT' AND B.RA_GRP_CD = 'HM') THEN 'GRAY 2'" ).append("\n"); 
		query.append("END ," ).append("\n"); 
		query.append("SI_GRP_CD = B.SI_GRP_CD ," ).append("\n"); 
		query.append("SI_GRP_NM = B.SI_GRP_NM ," ).append("\n"); 
		query.append("UPD_USR_ID = @[upd_usr_id] ," ).append("\n"); 
		query.append("UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT ( VNDR_SEQ ," ).append("\n"); 
		query.append("EV_YR ," ).append("\n"); 
		query.append("SI_SCRE ," ).append("\n"); 
		query.append("MODI_SI_SCRE ," ).append("\n"); 
		query.append("RA_SCRE ," ).append("\n"); 
		query.append("MODI_RA_SCRE ," ).append("\n"); 
		query.append("SI_GRP_CD ," ).append("\n"); 
		query.append("SI_GRP_NM ," ).append("\n"); 
		query.append("CRE_USR_ID ," ).append("\n"); 
		query.append("CRE_DT ," ).append("\n"); 
		query.append("UPD_USR_ID ," ).append("\n"); 
		query.append("UPD_DT )" ).append("\n"); 
		query.append("VALUES( B.VNDR_SEQ ," ).append("\n"); 
		query.append("B.EV_YR ," ).append("\n"); 
		query.append("B.SI_SCRE ," ).append("\n"); 
		query.append("ROUND( CASE WHEN @[SI_GRP_CD] = 'CR' THEN (B.SI_SCRE + (2.5 * 3 ))" ).append("\n"); 
		query.append("WHEN @[SI_GRP_CD] = 'LV' THEN (B.SI_SCRE + (2.5 * 1 ))" ).append("\n"); 
		query.append("WHEN @[SI_GRP_CD] = 'BN' THEN (B.SI_SCRE + (2.5 * 2 ))" ).append("\n"); 
		query.append("WHEN @[SI_GRP_CD] = 'RT' THEN (B.SI_SCRE + (2.5 * 0 ))" ).append("\n"); 
		query.append("END , 2) ," ).append("\n"); 
		query.append("B.RA_SCRE ," ).append("\n"); 
		query.append("B.MODI_RA_SCRE ," ).append("\n"); 
		query.append("B.SI_GRP_CD ," ).append("\n"); 
		query.append("B.SI_GRP_NM ," ).append("\n"); 
		query.append("@[cre_usr_id] ," ).append("\n"); 
		query.append("SYSDATE ," ).append("\n"); 
		query.append("@[upd_usr_id] ," ).append("\n"); 
		query.append("SYSDATE )" ).append("\n"); 

	}
}