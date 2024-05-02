/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ServiceProviderRelationshipAttractivenessResultDBDAOModifySpeRltSegmRsltCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.02.01 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipattractivenessresult.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ServiceProviderRelationshipAttractivenessResultDBDAOModifySpeRltSegmRsltCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SRS Analysis Result 등록 테이블에 merge into로 값을 insert or update한다.
	  * </pre>
	  */
	public ServiceProviderRelationshipAttractivenessResultDBDAOModifySpeRltSegmRsltCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atrc_to_sp_scre",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("atrc_to_hjs_scre",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ra_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipattractivenessresult.integration").append("\n"); 
		query.append("FileName : ServiceProviderRelationshipAttractivenessResultDBDAOModifySpeRltSegmRsltCSQL").append("\n"); 
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
		query.append("USING ( SELECT A.VNDR_SEQ" ).append("\n"); 
		query.append(",@[ev_yr] EV_YR" ).append("\n"); 
		query.append(",B.SI_GRP_CD" ).append("\n"); 
		query.append(",ROUND(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN @[ra_grp_cd] = 'HM' THEN" ).append("\n"); 
		query.append("SQRT(((TO_NUMBER(@[atrc_to_hjs_scre]) - 2.5)  * (TO_NUMBER(@[atrc_to_hjs_scre]) - 2.5)) + ((TO_NUMBER(@[atrc_to_sp_scre]) - 2.5)  * (TO_NUMBER(@[atrc_to_sp_scre]) - 2.5)))" ).append("\n"); 
		query.append("WHEN @[ra_grp_cd] = 'EX' THEN" ).append("\n"); 
		query.append("SQRT(((TO_NUMBER(@[atrc_to_hjs_scre]) - 2.5)  * (TO_NUMBER(@[atrc_to_hjs_scre]) - 2.5)) + ((TO_NUMBER(@[atrc_to_sp_scre]))  * (TO_NUMBER(@[atrc_to_sp_scre]))))" ).append("\n"); 
		query.append("WHEN @[ra_grp_cd] = 'DV' THEN" ).append("\n"); 
		query.append("SQRT((TO_NUMBER(@[atrc_to_hjs_scre])   * TO_NUMBER(@[atrc_to_hjs_scre]) ) + ((TO_NUMBER(@[atrc_to_sp_scre]) - 2.5)  * (TO_NUMBER(@[atrc_to_sp_scre]) - 2.5)))" ).append("\n"); 
		query.append("WHEN @[ra_grp_cd] = 'LM' THEN" ).append("\n"); 
		query.append("SQRT(((TO_NUMBER(@[atrc_to_hjs_scre]) )  * (TO_NUMBER(@[atrc_to_hjs_scre]) )) + ((TO_NUMBER(@[atrc_to_sp_scre]) )  * (TO_NUMBER(@[atrc_to_sp_scre]) )))" ).append("\n"); 
		query.append("END , 2) RA_SCRE" ).append("\n"); 
		query.append(",B.SI_SCRE" ).append("\n"); 
		query.append(",ROUND(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN B.SI_GRP_CD = 'CR' THEN" ).append("\n"); 
		query.append("(B.SI_SCRE + (2.5 * 3 ))" ).append("\n"); 
		query.append("WHEN B.SI_GRP_CD = 'LV' THEN" ).append("\n"); 
		query.append("(B.SI_SCRE + (2.5 * 1 ))" ).append("\n"); 
		query.append("WHEN B.SI_GRP_CD = 'BN' THEN" ).append("\n"); 
		query.append("(B.SI_SCRE + (2.5 * 2 ))" ).append("\n"); 
		query.append("WHEN B.SI_GRP_CD = 'RT' THEN" ).append("\n"); 
		query.append("(B.SI_SCRE + (2.5 * 0 ))" ).append("\n"); 
		query.append("END , 2) MODI_SI_SCRE" ).append("\n"); 
		query.append("FROM SPE_EV_GRP_SVC_PROV_MTCH A" ).append("\n"); 
		query.append(",SPE_EV_GRP_STRG_IMPT_RSLT B" ).append("\n"); 
		query.append(", SPE_EV_GRP C" ).append("\n"); 
		query.append("WHERE A.VNDR_SEQ = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("AND   @[ev_yr]  = B.EV_YR(+)" ).append("\n"); 
		query.append("AND   A.EG_ID = B.EG_ID(+)" ).append("\n"); 
		query.append("AND   A.EG_ID_SEQ = B.EG_ID_SEQ(+)" ).append("\n"); 
		query.append("AND   C.EG_ID = SUBSTR(@[eg_id],0,5)" ).append("\n"); 
		query.append("AND   C.EG_ID_SEQ = TO_NUMBER(@[eg_id_seq])" ).append("\n"); 
		query.append("AND   A.EG_ID = C.EG_ID" ).append("\n"); 
		query.append("AND   A.EG_ID_SEQ = C.EG_ID_SEQ" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("ON (A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("AND  A.EV_YR = B.EV_YR)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("RA_SCRE =  B.RA_SCRE," ).append("\n"); 
		query.append("SI_SCRE =  B.SI_SCRE," ).append("\n"); 
		query.append("MODI_SI_SCRE =  B.MODI_SI_SCRE," ).append("\n"); 
		query.append("MODI_RA_SCRE =  ROUND(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN @[ra_grp_cd] = 'HM' THEN" ).append("\n"); 
		query.append("(TO_NUMBER(B.RA_SCRE) + (2.5 * 3 ))" ).append("\n"); 
		query.append("WHEN @[ra_grp_cd] = 'EX' THEN" ).append("\n"); 
		query.append("(TO_NUMBER(B.RA_SCRE) + (2.5 * 2 ))" ).append("\n"); 
		query.append("WHEN @[ra_grp_cd] = 'DV' THEN" ).append("\n"); 
		query.append("(TO_NUMBER(B.RA_SCRE) + (2.5 * 1 ))" ).append("\n"); 
		query.append("WHEN @[ra_grp_cd] = 'LM' THEN" ).append("\n"); 
		query.append("(TO_NUMBER(B.RA_SCRE) + (2.5 * 0 ))" ).append("\n"); 
		query.append("END , 2)," ).append("\n"); 
		query.append("SRS_GRP_CD  =   CASE" ).append("\n"); 
		query.append("WHEN (B.SI_GRP_CD = 'CR' AND @[ra_grp_cd] = 'LM') THEN 'G1'" ).append("\n"); 
		query.append("WHEN (B.SI_GRP_CD = 'CR' AND @[ra_grp_cd] = 'EX') THEN 'C1'" ).append("\n"); 
		query.append("WHEN (B.SI_GRP_CD = 'CR' AND @[ra_grp_cd] = 'DV') THEN 'C2'" ).append("\n"); 
		query.append("WHEN (B.SI_GRP_CD = 'CR' AND @[ra_grp_cd] = 'HM') THEN 'ST'" ).append("\n"); 
		query.append("WHEN (B.SI_GRP_CD = 'BN' AND @[ra_grp_cd] = 'LM') THEN 'TA'" ).append("\n"); 
		query.append("WHEN (B.SI_GRP_CD = 'BN' AND @[ra_grp_cd] = 'EX') THEN 'TA'" ).append("\n"); 
		query.append("WHEN (B.SI_GRP_CD = 'BN' AND @[ra_grp_cd] = 'DV') THEN 'C3'" ).append("\n"); 
		query.append("WHEN (B.SI_GRP_CD = 'BN' AND @[ra_grp_cd] = 'HM') THEN 'C4'" ).append("\n"); 
		query.append("WHEN (B.SI_GRP_CD = 'LV' AND @[ra_grp_cd] = 'LM') THEN 'TA'" ).append("\n"); 
		query.append("WHEN (B.SI_GRP_CD = 'LV' AND @[ra_grp_cd] = 'EX') THEN 'TA'" ).append("\n"); 
		query.append("WHEN (B.SI_GRP_CD = 'LV' AND @[ra_grp_cd] = 'DV') THEN 'TA'" ).append("\n"); 
		query.append("WHEN (B.SI_GRP_CD = 'LV' AND @[ra_grp_cd] = 'HM') THEN 'C5'" ).append("\n"); 
		query.append("WHEN (B.SI_GRP_CD = 'RT' AND @[ra_grp_cd] = 'LM') THEN 'TA'" ).append("\n"); 
		query.append("WHEN (B.SI_GRP_CD = 'RT' AND @[ra_grp_cd] = 'EX') THEN 'TA'" ).append("\n"); 
		query.append("WHEN (B.SI_GRP_CD = 'RT' AND @[ra_grp_cd] = 'DV') THEN 'TA'" ).append("\n"); 
		query.append("WHEN (B.SI_GRP_CD = 'RT' AND @[ra_grp_cd] = 'HM') THEN 'G2'" ).append("\n"); 
		query.append("END," ).append("\n"); 
		query.append("SRS_GRP_NM =    CASE" ).append("\n"); 
		query.append("WHEN (B.SI_GRP_CD = 'CR' AND @[ra_grp_cd] = 'LM') THEN 'GRAY'" ).append("\n"); 
		query.append("WHEN (B.SI_GRP_CD = 'CR' AND @[ra_grp_cd] = 'EX') THEN 'COLLABORATIVE'" ).append("\n"); 
		query.append("WHEN (B.SI_GRP_CD = 'CR' AND @[ra_grp_cd] = 'DV') THEN 'COLLABORATIVE'" ).append("\n"); 
		query.append("WHEN (B.SI_GRP_CD = 'CR' AND @[ra_grp_cd] = 'HM') THEN 'STRATEGIC'" ).append("\n"); 
		query.append("WHEN (B.SI_GRP_CD = 'BN' AND @[ra_grp_cd] = 'LM') THEN 'TRANSACTIONAL'" ).append("\n"); 
		query.append("WHEN (B.SI_GRP_CD = 'BN' AND @[ra_grp_cd] = 'EX') THEN 'TRANSACTIONAL'" ).append("\n"); 
		query.append("WHEN (B.SI_GRP_CD = 'BN' AND @[ra_grp_cd] = 'DV') THEN 'COLLABORATIVE'" ).append("\n"); 
		query.append("WHEN (B.SI_GRP_CD = 'BN' AND @[ra_grp_cd] = 'HM') THEN 'COLLABORATIVE'" ).append("\n"); 
		query.append("WHEN (B.SI_GRP_CD = 'LV' AND @[ra_grp_cd] = 'LM') THEN 'TRANSACTIONAL'" ).append("\n"); 
		query.append("WHEN (B.SI_GRP_CD = 'LV' AND @[ra_grp_cd] = 'EX') THEN 'TRANSACTIONAL'" ).append("\n"); 
		query.append("WHEN (B.SI_GRP_CD = 'LV' AND @[ra_grp_cd] = 'DV') THEN 'TRANSACTIONAL'" ).append("\n"); 
		query.append("WHEN (B.SI_GRP_CD = 'LV' AND @[ra_grp_cd] = 'HM') THEN 'COLLABORATIVE'" ).append("\n"); 
		query.append("WHEN (B.SI_GRP_CD = 'RT' AND @[ra_grp_cd] = 'LM') THEN 'TRANSACTIONAL'" ).append("\n"); 
		query.append("WHEN (B.SI_GRP_CD = 'RT' AND @[ra_grp_cd] = 'EX') THEN 'TRANSACTIONAL'" ).append("\n"); 
		query.append("WHEN (B.SI_GRP_CD = 'RT' AND @[ra_grp_cd] = 'DV') THEN 'TRANSACTIONAL'" ).append("\n"); 
		query.append("WHEN (B.SI_GRP_CD = 'RT' AND @[ra_grp_cd] = 'HM') THEN 'GRAY 2'" ).append("\n"); 
		query.append("END," ).append("\n"); 
		query.append("UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT ( VNDR_SEQ" ).append("\n"); 
		query.append(",EV_YR" ).append("\n"); 
		query.append(",SI_SCRE" ).append("\n"); 
		query.append(",MODI_SI_SCRE" ).append("\n"); 
		query.append(",RA_SCRE" ).append("\n"); 
		query.append(",MODI_RA_SCRE" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES( B.VNDR_SEQ" ).append("\n"); 
		query.append(",B.EV_YR" ).append("\n"); 
		query.append(",B.SI_SCRE" ).append("\n"); 
		query.append(",B.MODI_SI_SCRE" ).append("\n"); 
		query.append(",B.RA_SCRE" ).append("\n"); 
		query.append(",ROUND(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN @[ra_grp_cd] = 'HM' THEN" ).append("\n"); 
		query.append("(B.RA_SCRE + (2.5 * 3 ))" ).append("\n"); 
		query.append("WHEN @[ra_grp_cd] = 'EX' THEN" ).append("\n"); 
		query.append("(B.RA_SCRE + (2.5 * 2 ))" ).append("\n"); 
		query.append("WHEN @[ra_grp_cd] = 'DV' THEN" ).append("\n"); 
		query.append("(B.RA_SCRE + (2.5 * 1 ))" ).append("\n"); 
		query.append("WHEN @[ra_grp_cd] = 'LM' THEN" ).append("\n"); 
		query.append("(B.RA_SCRE + (2.5 * 0 ))" ).append("\n"); 
		query.append("END , 2)" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}