/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOAddTermChangeCntrStatusHistoryDiFlgYDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.03
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2010.05.03 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOAddTermChangeCntrStatusHistoryDiFlgYDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddTermChangeCntrStatusHistoryDiFlgYData
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOAddTermChangeCntrStatusHistoryDiFlgYDataCSQL(){
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
		params.put("dir_itchg_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dii_fee",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOAddTermChangeCntrStatusHistoryDiFlgYDataCSQL").append("\n"); 
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
		query.append("    MST_CNTR_STS_HIS_SEQ.NEXTVAL AS CNTR_STS_SEQ," ).append("\n"); 
		query.append("    'H' AS CO_CD," ).append("\n"); 
		query.append("    @[yd_cd] YD_CD,    " ).append("\n"); 
		query.append("    @[loc_cd] LOC_CD," ).append("\n"); 
		query.append("    @[scc_cd] SCC_CD," ).append("\n"); 
		query.append("    @[lcc_cd] LCC_CD," ).append("\n"); 
		query.append("    @[ecc_cd] ECC_CD," ).append("\n"); 
		query.append("    @[rcc_cd] RCC_CD," ).append("\n"); 
		query.append("    DECODE(LEVEL,1,@[cur_agmt_cty_cd],2,@[aft_agmt_cty_cd]) AS AGMT_CTY_CD," ).append("\n"); 
		query.append("    DECODE(LEVEL,1,@[cur_agmt_seq],2,@[aft_agmt_seq]) AS AGMT_SEQ, " ).append("\n"); 
		query.append("    CASE " ).append("\n"); 
		query.append("    	 WHEN 'MUO' = @[cntr_sts_cd] THEN" ).append("\n"); 
		query.append("            DECODE(LEVEL,1,'MUI',2,'DIO') " ).append("\n"); 
		query.append("       WHEN 'LSI' = @[cntr_sts_cd] THEN" ).append("\n"); 
		query.append("            DECODE(LEVEL,1,'LSO',2,'DII')" ).append("\n"); 
		query.append("    END CNTR_STS_CD,  " ).append("\n"); 
		query.append("    @[ofc_cd]     AS OFC_CD," ).append("\n"); 
		query.append("    TO_DATE(@[act_dt],'YYYYMMDD') AS CNTR_STS_EVNT_DT,        -- Activity Date--" ).append("\n"); 
		query.append("    CASE " ).append("\n"); 
		query.append("         WHEN 'MUO' = @[cntr_sts_cd] THEN" ).append("\n"); 
		query.append("            DECODE(LEVEL,1,(CASE WHEN TO_NUMBER(@[cntr_pkup_psv_amt]) > 0 THEN" ).append("\n"); 
		query.append("                                            @[cntr_pkup_psv_amt]" ).append("\n"); 
		query.append("                                        WHEN TO_NUMBER(@[cntr_pkup_ngv_amt]) > 0 THEN" ).append("\n"); 
		query.append("                                            TO_CHAR(TO_NUMBER(@[cntr_pkup_ngv_amt])*-1)" ).append("\n"); 
		query.append("                                        END" ).append("\n"); 
		query.append("                            )                            " ).append("\n"); 
		query.append("                        ,2,NULL) " ).append("\n"); 
		query.append("         WHEN 'LSI' = @[cntr_sts_cd] THEN" ).append("\n"); 
		query.append("            DECODE(LEVEL,1,NULL,2,(CASE WHEN TO_NUMBER(@[cntr_pkup_psv_amt]) > 0 THEN" ).append("\n"); 
		query.append("                                            @[cntr_pkup_psv_amt]" ).append("\n"); 
		query.append("                                        WHEN TO_NUMBER(@[cntr_pkup_ngv_amt]) > 0 THEN" ).append("\n"); 
		query.append("                                            TO_CHAR(TO_NUMBER(@[cntr_pkup_ngv_amt])*-1)" ).append("\n"); 
		query.append("                                        END" ).append("\n"); 
		query.append("                                   ) " ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("    END CNTR_PKUP_CHG_AMT,           " ).append("\n"); 
		query.append("    'USD' AS CURR_CD," ).append("\n"); 
		query.append("    CASE " ).append("\n"); 
		query.append("         WHEN 'MUO' = @[cntr_sts_cd] THEN" ).append("\n"); 
		query.append("            DECODE(LEVEL,1,NULL,2,NULL) " ).append("\n"); 
		query.append("         WHEN 'LSI' = @[cntr_sts_cd] THEN" ).append("\n"); 
		query.append("            DECODE(LEVEL,1,NULL,2,NULL)" ).append("\n"); 
		query.append("    END RNTL_CHG_FREE_DYS, " ).append("\n"); 
		query.append("    CASE " ).append("\n"); 
		query.append("         WHEN 'MUO' = @[cntr_sts_cd] THEN" ).append("\n"); 
		query.append("            DECODE(LEVEL,1,NULL,2,@[dii_fee]) " ).append("\n"); 
		query.append("         WHEN 'LSI' = @[cntr_sts_cd] THEN" ).append("\n"); 
		query.append("            DECODE(LEVEL,1,NULL,2,@[dii_fee])" ).append("\n"); 
		query.append("    END CNTR_DIR_ITCHG_FEE_AMT, " ).append("\n"); 
		query.append("    CASE " ).append("\n"); 
		query.append("         WHEN 'MUO' = @[cntr_sts_cd] THEN" ).append("\n"); 
		query.append("            DECODE(LEVEL,1,NULL,2,@[dir_itchg_vndr_seq]) " ).append("\n"); 
		query.append("         WHEN 'LSI' = @[cntr_sts_cd] THEN" ).append("\n"); 
		query.append("            DECODE(LEVEL,1,NULL,2,@[dir_itchg_vndr_seq])" ).append("\n"); 
		query.append("    END DIR_ITCHG_VNDR_SEQ, " ).append("\n"); 
		query.append("    'Y' AS CNTR_LSTM_CNG_FLG,       " ).append("\n"); 
		query.append("    CASE " ).append("\n"); 
		query.append("    		WHEN 'MUO' = @[cntr_sts_cd] THEN" ).append("\n"); 
		query.append("            DECODE(LEVEL,1,(SELECT  /*+ INDEX_DESC(A XAK1MST_CNTR_STS_HIS) */ A.YD_CD" ).append("\n"); 
		query.append("                            FROM    MST_CNTR_STS_HIS A" ).append("\n"); 
		query.append("                            WHERE   A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                            AND     A.CNTR_STS_CD = 'MUO'" ).append("\n"); 
		query.append("                            AND     ROWNUM =1" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                        ,2,(SELECT  /*+ INDEX_DESC(A XAK1MST_CNTR_STS_HIS) */ A.YD_CD" ).append("\n"); 
		query.append("                            FROM    MST_CNTR_STS_HIS A" ).append("\n"); 
		query.append("                            WHERE   A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                            AND     A.CNTR_STS_CD = 'LSI'" ).append("\n"); 
		query.append("                            AND     ROWNUM =1                        " ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                  ) " ).append("\n"); 
		query.append("            WHEN 'LSI' = @[cntr_sts_cd] THEN            " ).append("\n"); 
		query.append("            DECODE(LEVEL,1,(SELECT  /*+ INDEX_DESC(A XAK1MST_CNTR_STS_HIS) */ A.YD_CD" ).append("\n"); 
		query.append("                            FROM    MST_CNTR_STS_HIS A" ).append("\n"); 
		query.append("                            WHERE   A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                            AND     A.CNTR_STS_CD = 'LSI'" ).append("\n"); 
		query.append("                            AND     ROWNUM =1" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                        ,2,NULL" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("    END PRNR_YD_CD, " ).append("\n"); 
		query.append("    CASE " ).append("\n"); 
		query.append("        WHEN 'MUO' = @[cntr_sts_cd] THEN" ).append("\n"); 
		query.append("            DECODE(LEVEL,1,(SELECT  /*+ INDEX_DESC(A XAK1MST_CNTR_STS_HIS) */ A.CNTR_STS_SEQ" ).append("\n"); 
		query.append("                            FROM    MST_CNTR_STS_HIS A" ).append("\n"); 
		query.append("                            WHERE   A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                            AND     A.CNTR_STS_CD = 'MUO'" ).append("\n"); 
		query.append("                            AND     ROWNUM =1" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                        ,2,(SELECT  /*+ INDEX_DESC(A XAK1MST_CNTR_STS_HIS) */ A.CNTR_STS_SEQ" ).append("\n"); 
		query.append("                            FROM    MST_CNTR_STS_HIS A" ).append("\n"); 
		query.append("                            WHERE   A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                            AND     A.CNTR_STS_CD = 'LSI'" ).append("\n"); 
		query.append("                            AND     ROWNUM =1                        " ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                  ) " ).append("\n"); 
		query.append("       WHEN 'LSI' = @[cntr_sts_cd] THEN            " ).append("\n"); 
		query.append("            DECODE(LEVEL,1,(SELECT  /*+ INDEX_DESC(A XAK1MST_CNTR_STS_HIS) */ A.CNTR_STS_SEQ" ).append("\n"); 
		query.append("                            FROM    MST_CNTR_STS_HIS A" ).append("\n"); 
		query.append("                            WHERE   A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                            AND     A.CNTR_STS_CD = 'LSI'" ).append("\n"); 
		query.append("                            AND     ROWNUM =1" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                        ,2,NULL" ).append("\n"); 
		query.append("                  )                               " ).append("\n"); 
		query.append("    END PRNR_STS_SEQ,     " ).append("\n"); 
		query.append("    @[cnmv_sts_cd] AS CNMV_STS_CD," ).append("\n"); 
		query.append("    @[cntr_full_flg] AS CNTR_FULL_FLG,           " ).append("\n"); 
		query.append("    CASE " ).append("\n"); 
		query.append("         WHEN 'MUO' = @[cntr_sts_cd] THEN" ).append("\n"); 
		query.append("            DECODE(LEVEL,1,NULL,2,NULL) " ).append("\n"); 
		query.append("         WHEN 'LSI' = @[cntr_sts_cd] THEN" ).append("\n"); 
		query.append("            DECODE(LEVEL,1,NULL,2,NULL)" ).append("\n"); 
		query.append("    END CNTR_MIN_ONH_DYS,  " ).append("\n"); 
		query.append("    @[cre_usr_id]     AS CRE_USR_ID," ).append("\n"); 
		query.append("    SYSDATE AS CRE_DT," ).append("\n"); 
		query.append("    @[upd_usr_id]      AS UPD_USR_ID," ).append("\n"); 
		query.append("    SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("CONNECT BY LEVEL <=2" ).append("\n"); 

	}
}