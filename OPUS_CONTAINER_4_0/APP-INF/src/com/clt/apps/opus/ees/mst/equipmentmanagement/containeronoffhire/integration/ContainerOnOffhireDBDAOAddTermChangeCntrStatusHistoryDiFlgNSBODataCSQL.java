/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOAddTermChangeCntrStatusHistoryDiFlgNSBODataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.20
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2015.10.20 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOAddTermChangeCntrStatusHistoryDiFlgNSBODataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddTermChangeCntrStatusHistoryDiFlgNSBOData
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOAddTermChangeCntrStatusHistoryDiFlgNSBODataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_pkup_psv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_pkup_ngv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cur_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cur_agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_full_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("scc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rntl_chg_free_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_min_onh_dys",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOAddTermChangeCntrStatusHistoryDiFlgNSBODataCSQL").append("\n"); 
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
		query.append("INSERT INTO MST_CNTR_STS_HIS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("     CNTR_NO" ).append("\n"); 
		query.append("    ,CNTR_STS_SEQ" ).append("\n"); 
		query.append("    ,CO_CD" ).append("\n"); 
		query.append("    ,YD_CD" ).append("\n"); 
		query.append("    ,LOC_CD" ).append("\n"); 
		query.append("    ,SCC_CD" ).append("\n"); 
		query.append("    ,LCC_CD" ).append("\n"); 
		query.append("    ,ECC_CD" ).append("\n"); 
		query.append("    ,RCC_CD" ).append("\n"); 
		query.append("    ,AGMT_CTY_CD" ).append("\n"); 
		query.append("    ,AGMT_SEQ" ).append("\n"); 
		query.append("    ,CNTR_STS_CD" ).append("\n"); 
		query.append("    ,OFC_CD" ).append("\n"); 
		query.append("    ,CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append("    ,CNTR_PKUP_CHG_AMT" ).append("\n"); 
		query.append("    ,CURR_CD" ).append("\n"); 
		query.append("    ,RNTL_CHG_FREE_DYS" ).append("\n"); 
		query.append("    ,CNTR_DIR_ITCHG_FEE_AMT" ).append("\n"); 
		query.append("    ,DIR_ITCHG_VNDR_SEQ   " ).append("\n"); 
		query.append("    ,CNTR_LSTM_CNG_FLG" ).append("\n"); 
		query.append("    ,PRNR_YD_CD" ).append("\n"); 
		query.append("    ,PRNR_STS_SEQ" ).append("\n"); 
		query.append("    ,CNMV_STS_CD" ).append("\n"); 
		query.append("    ,CNTR_FULL_FLG" ).append("\n"); 
		query.append("    ,CNTR_MIN_ONH_DYS" ).append("\n"); 
		query.append("    ,CRE_USR_ID" ).append("\n"); 
		query.append("    ,CRE_DT" ).append("\n"); 
		query.append("    ,UPD_USR_ID" ).append("\n"); 
		query.append("    ,UPD_DT    " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    @[cntr_no] AS CNTR_NO," ).append("\n"); 
		query.append("    B.CNTR_STS_SEQ,       " ).append("\n"); 
		query.append("    'O' AS CO_CD," ).append("\n"); 
		query.append("    @[yd_cd]  AS YD_CD," ).append("\n"); 
		query.append("    @[loc_cd] LOC_CD," ).append("\n"); 
		query.append("    @[scc_cd] SCC_CD," ).append("\n"); 
		query.append("    @[lcc_cd] LCC_CD," ).append("\n"); 
		query.append("    @[ecc_cd] ECC_CD," ).append("\n"); 
		query.append("    @[rcc_cd] RCC_CD,    " ).append("\n"); 
		query.append("    DECODE(B.SEQ,1,A.AGMT_CTY_CD,2,@[cur_agmt_cty_cd],3,@[aft_agmt_cty_cd],4,A.AGMT_CTY_CD ) AS AGMT_CTY_CD," ).append("\n"); 
		query.append("    DECODE(B.SEQ,1,A.AGMT_SEQ,2,@[cur_agmt_seq],3,@[aft_agmt_seq],4,A.AGMT_SEQ ) AS AGMT_SEQ,        " ).append("\n"); 
		query.append("    CASE " ).append("\n"); 
		query.append("        WHEN 'OW' = @[aft_lstm_cd]  THEN   DECODE(B.SEQ,1,SUBSTR(@[cntr_sts_cd], 1, 2)||'I',2,'LSO',3,'OWN',4,SUBSTR(@[cntr_sts_cd], 1, 2)||'O') --SBO/SBI, MUO/MUI" ).append("\n"); 
		query.append("        WHEN 'OW' != @[aft_lstm_cd] THEN   DECODE(B.SEQ,1,SUBSTR(@[cntr_sts_cd], 1, 2)||'I',2,'LSO',3,'LSI',4,SUBSTR(@[cntr_sts_cd], 1, 2)||'O') --SBO/SBI, MUO/MUI" ).append("\n"); 
		query.append("    END CNTR_STS_CD,    " ).append("\n"); 
		query.append("    @[ofc_cd]     AS OFC_CD," ).append("\n"); 
		query.append("    DECODE( CASE " ).append("\n"); 
		query.append("            WHEN 'OW' = @[aft_lstm_cd]  THEN   DECODE(B.SEQ,1,SUBSTR(@[cntr_sts_cd], 1, 2)||'I',2,'LSO',3,'OWN',4,SUBSTR(@[cntr_sts_cd], 1, 2)||'O') --SBO/SBI, MUO/MUI" ).append("\n"); 
		query.append("            WHEN 'OW' != @[aft_lstm_cd] THEN   DECODE(B.SEQ,1,SUBSTR(@[cntr_sts_cd], 1, 2)||'I',2,'LSO',3,'LSI',4,SUBSTR(@[cntr_sts_cd], 1, 2)||'O') --SBO/SBI, MUO/MUI" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("            , 'LSO', TO_DATE(@[act_dt],'YYYYMMDD')-1" ).append("\n"); 
		query.append("            , 'SBI', TO_DATE(@[act_dt],'YYYYMMDD')-1" ).append("\n"); 
		query.append("            , 'MUI', TO_DATE(@[act_dt],'YYYYMMDD')-1 " ).append("\n"); 
		query.append("            , TO_DATE(@[act_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("          ) AS CNTR_STS_EVNT_DT,        -- Activity Date-- " ).append("\n"); 
		query.append("    DECODE(B.SEQ,1,0,2,0,3,(CASE WHEN TO_NUMBER(@[cntr_pkup_psv_amt]) > 0 THEN" ).append("\n"); 
		query.append("                                            @[cntr_pkup_psv_amt]" ).append("\n"); 
		query.append("                                        WHEN TO_NUMBER(@[cntr_pkup_ngv_amt]) > 0 THEN" ).append("\n"); 
		query.append("                                            TO_CHAR(TO_NUMBER(@[cntr_pkup_ngv_amt])*-1)" ).append("\n"); 
		query.append("                                        END" ).append("\n"); 
		query.append("                            ),4,0) CNTR_PKUP_CHG_AMT," ).append("\n"); 
		query.append("	DECODE(B.SEQ,1,''" ).append("\n"); 
		query.append("                ,2,''" ).append("\n"); 
		query.append("                ,3,''" ).append("\n"); 
		query.append("                ,4,NVL((SELECT /*+ INDEX_DESC(A XAK1MST_CNTR_STS_HIS) */ A.CURR_CD" ).append("\n"); 
		query.append("                          FROM MST_CNTR_STS_HIS A" ).append("\n"); 
		query.append("                         WHERE A.CNTR_NO     = @[cntr_no]" ).append("\n"); 
		query.append("                           AND A.CNTR_STS_CD = SUBSTR(@[cntr_sts_cd], 1, 2)||'O'" ).append("\n"); 
		query.append("                           AND ROWNUM        = 1), '')" ).append("\n"); 
		query.append("          ) AS CURR_CD," ).append("\n"); 
		query.append("	DECODE(B.SEQ,1,0" ).append("\n"); 
		query.append("                ,2,0" ).append("\n"); 
		query.append("                ,3,@[rntl_chg_free_dys]" ).append("\n"); 
		query.append("                ,4,NVL((SELECT /*+ INDEX_DESC(A XAK1MST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("                              DECODE(SIGN((TRUNC(A.CNTR_STS_EVNT_DT) + A.RNTL_CHG_FREE_DYS ) -  TO_DATE(@[act_dt],'YYYYMMDD'))" ).append("\n"); 
		query.append("                                         , 1, ((TRUNC(A.CNTR_STS_EVNT_DT) + A.RNTL_CHG_FREE_DYS ) -  TO_DATE(@[act_dt],'YYYYMMDD'))" ).append("\n"); 
		query.append("                                         , 0) " ).append("\n"); 
		query.append("                          FROM MST_CNTR_STS_HIS A" ).append("\n"); 
		query.append("                         WHERE A.CNTR_NO     = @[cntr_no]" ).append("\n"); 
		query.append("                           AND A.CNTR_STS_CD = SUBSTR(@[cntr_sts_cd], 1, 2)||'O'" ).append("\n"); 
		query.append("                           AND ROWNUM        = 1), 0)" ).append("\n"); 
		query.append("          ) RNTL_CHG_FREE_DYS," ).append("\n"); 
		query.append("    NULL CNTR_DIR_ITCHG_FEE_AMT," ).append("\n"); 
		query.append("    NULL DIR_ITCHG_VNDR_SEQ," ).append("\n"); 
		query.append("    'Y' AS CNTR_LSTM_CNG_FLG, " ).append("\n"); 
		query.append("    (SELECT /*+ INDEX_DESC(A XAK1MST_CNTR_STS_HIS) */  A.YD_CD" ).append("\n"); 
		query.append("       FROM MST_CNTR_STS_HIS A" ).append("\n"); 
		query.append("      WHERE   A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("        AND     A.CNTR_STS_CD IN (  DECODE(B.SEQ, 1, SUBSTR(@[cntr_sts_cd], 1, 2)||'O', 'XXX') -- Search SBO/MUO Parent Sequence" ).append("\n"); 
		query.append("                                  , DECODE(B.SEQ, 2, 'OWN', 'XXX') -- Search LSO Parent Sequence - OWN and LSI" ).append("\n"); 
		query.append("                                  , DECODE(B.SEQ, 2, 'LSI', 'XXX') -- Search LSO Parent Sequence - OWN and LSI" ).append("\n"); 
		query.append("                                 )" ).append("\n"); 
		query.append("        AND     ROWNUM =1) AS PRNR_YD_CD," ).append("\n"); 
		query.append("    (SELECT /*+ INDEX_DESC(A XAK1MST_CNTR_STS_HIS) */  CNTR_STS_SEQ" ).append("\n"); 
		query.append("       FROM MST_CNTR_STS_HIS A" ).append("\n"); 
		query.append("      WHERE   A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("        AND     A.CNTR_STS_CD IN (  DECODE(B.SEQ, 1, SUBSTR(@[cntr_sts_cd], 1, 2)||'O', 'XXX') -- Search SBO/MUO Parent Sequence" ).append("\n"); 
		query.append("                                  , DECODE(B.SEQ, 2, 'OWN', 'XXX') -- Search LSO Parent Sequence - OWN and LSI" ).append("\n"); 
		query.append("                                  , DECODE(B.SEQ, 2, 'LSI', 'XXX') -- Search LSO Parent Sequence - OWN and LSI" ).append("\n"); 
		query.append("                                 )" ).append("\n"); 
		query.append("        AND     ROWNUM =1) AS PRNR_STS_SEQ," ).append("\n"); 
		query.append("    @[cnmv_sts_cd] AS CNMV_STS_CD," ).append("\n"); 
		query.append("    @[cntr_full_flg] AS CNTR_FULL_FLG," ).append("\n"); 
		query.append("    DECODE(B.SEQ,1,0,2,0,3,@[cntr_min_onh_dys],4,0) CNTR_MIN_ONH_DYS," ).append("\n"); 
		query.append("    @[cre_usr_id]     AS CRE_USR_ID," ).append("\n"); 
		query.append("    SYSDATE AS CRE_DT," ).append("\n"); 
		query.append("    @[upd_usr_id]      AS UPD_USR_ID," ).append("\n"); 
		query.append("    SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    (SELECT /*+ INDEX_DESC(A XAK1MST_CNTR_STS_HIS) */ " ).append("\n"); 
		query.append("            AGMT_CTY_CD,A.AGMT_SEQ" ).append("\n"); 
		query.append("    FROM MST_CNTR_STS_HIS A" ).append("\n"); 
		query.append("    WHERE   A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("    AND     A.CNTR_STS_CD = @[cntr_sts_cd]" ).append("\n"); 
		query.append("    AND     ROWNUM =1) A ," ).append("\n"); 
		query.append("    (SELECT LEVEL SEQ," ).append("\n"); 
		query.append("            MST_CNTR_STS_HIS_SEQ_FNC('N') AS CNTR_STS_SEQ" ).append("\n"); 
		query.append("     FROM DUAL " ).append("\n"); 
		query.append("     CONNECT BY LEVEL <=4) B" ).append("\n"); 

	}
}