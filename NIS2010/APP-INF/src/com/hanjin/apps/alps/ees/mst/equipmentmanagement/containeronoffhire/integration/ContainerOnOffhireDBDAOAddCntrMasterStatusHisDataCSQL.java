/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOAddCntrMasterStatusHisDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.11
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOAddCntrMasterStatusHisDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddCntrMasterStatusHisData
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOAddCntrMasterStatusHisDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_lft_chg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hire_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_drff_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts_evnt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("his_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("full_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_drff_cr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_pkup_chg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_lft_chg_cur",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_pkup_cr_chg_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("st_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOAddCntrMasterStatusHisDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MST_CNTR_STS_HIS (" ).append("\n"); 
		query.append("  CNTR_NO      " ).append("\n"); 
		query.append(", CNTR_STS_SEQ " ).append("\n"); 
		query.append(", CO_CD        " ).append("\n"); 
		query.append(", YD_CD        " ).append("\n"); 
		query.append(", LOC_CD       " ).append("\n"); 
		query.append(", SCC_CD       " ).append("\n"); 
		query.append(", ECC_CD       " ).append("\n"); 
		query.append(", LCC_CD       " ).append("\n"); 
		query.append(", RCC_CD       " ).append("\n"); 
		query.append(", AGMT_CTY_CD  " ).append("\n"); 
		query.append(", AGMT_SEQ     " ).append("\n"); 
		query.append(", CNTR_STS_CD  " ).append("\n"); 
		query.append(", OFC_CD       " ).append("\n"); 
		query.append(", CNTR_STS_EVNT_DT " ).append("\n"); 
		query.append("#if (${st_cd} == '1' || ${st_cd} == '3'|| ${st_cd} == '5' || ${st_cd} == '7')" ).append("\n"); 
		query.append(", CNTR_PKUP_CHG_AMT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", CURR_CD" ).append("\n"); 
		query.append("#if (${st_cd} == '0' || ${st_cd} == '2' || ${st_cd} == '4' || ${st_cd} == '6')" ).append("\n"); 
		query.append(", CNTR_DRFF_CR_AMT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${st_cd} == '0' || ${st_cd} == '2' || ${st_cd} == '4' || ${st_cd} == '6' || ${st_cd} == '7')" ).append("\n"); 
		query.append(", PRNR_YD_CD       " ).append("\n"); 
		query.append(", PRNR_STS_SEQ     " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", CNTR_STS_RMK     " ).append("\n"); 
		query.append(", CNMV_STS_CD      " ).append("\n"); 
		query.append(", CNTR_FULL_FLG    " ).append("\n"); 
		query.append(", CRE_USR_ID       " ).append("\n"); 
		query.append(", CRE_DT           " ).append("\n"); 
		query.append(", UPD_USR_ID       " ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", RNTL_CHG_FREE_DYS" ).append("\n"); 
		query.append(", CNTR_LFT_CHG_AMT" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append(" @[cntr_no]                                                     " ).append("\n"); 
		query.append(", @[his_seq]                                                     " ).append("\n"); 
		query.append(", 'H'                                                            " ).append("\n"); 
		query.append(", @[sts_evnt_yd_cd]                                              " ).append("\n"); 
		query.append(", SUBSTR(@[sts_evnt_yd_cd], 1, 5)                                " ).append("\n"); 
		query.append(", (SELECT A.SCC_CD FROM MDM_LOCATION A,MDM_EQ_ORZ_CHT B WHERE A.LOC_CD = SUBSTR(@[sts_evnt_yd_cd], 1, 5) AND   A.SCC_CD = B.SCC_CD)" ).append("\n"); 
		query.append(", (SELECT B.ECC_CD FROM MDM_LOCATION A,MDM_EQ_ORZ_CHT B WHERE A.LOC_CD = SUBSTR(@[sts_evnt_yd_cd], 1, 5) AND   A.SCC_CD = B.SCC_CD)" ).append("\n"); 
		query.append(", (SELECT B.LCC_CD FROM MDM_LOCATION A,MDM_EQ_ORZ_CHT B WHERE A.LOC_CD = SUBSTR(@[sts_evnt_yd_cd], 1, 5) AND   A.SCC_CD = B.SCC_CD)" ).append("\n"); 
		query.append(", (SELECT B.RCC_CD FROM MDM_LOCATION A,MDM_EQ_ORZ_CHT B WHERE A.LOC_CD = SUBSTR(@[sts_evnt_yd_cd], 1, 5) AND   A.SCC_CD = B.SCC_CD)" ).append("\n"); 
		query.append("#if (${st_cd} == '1' || ${st_cd} == '3'|| ${st_cd} == '5')                 " ).append("\n"); 
		query.append(", @[agmt_cty_cd]" ).append("\n"); 
		query.append(", TO_NUMBER(@[agmt_seq])" ).append("\n"); 
		query.append("#elseif (${st_cd} == '0' || ${st_cd} == '7') " ).append("\n"); 
		query.append(", SUBSTR(@[agmt_no], 1, 3)" ).append("\n"); 
		query.append(", TO_NUMBER(SUBSTR(@[agmt_no], 4, 6))" ).append("\n"); 
		query.append("#elseif (${st_cd} == '2')" ).append("\n"); 
		query.append(", 'HHO'" ).append("\n"); 
		query.append(", (SELECT /*+ INDEX_DESC(H XAK1MST_CNTR_STS_HIS) */ AGMT_SEQ FROM MST_CNTR_STS_HIS H WHERE CNTR_NO =  @[cntr_no] AND CNTR_STS_CD = 'SBO' AND ROWNUM = 1)" ).append("\n"); 
		query.append("#elseif (${st_cd} == '4')" ).append("\n"); 
		query.append(", 'HHO'" ).append("\n"); 
		query.append(", (SELECT /*+ INDEX_DESC(H XAK1MST_CNTR_STS_HIS) */ AGMT_SEQ FROM MST_CNTR_STS_HIS H WHERE CNTR_NO =  @[cntr_no] AND CNTR_STS_CD = 'MUO' AND ROWNUM = 1)" ).append("\n"); 
		query.append("#elseif (${st_cd} == '6')" ).append("\n"); 
		query.append(", 'HHO'" ).append("\n"); 
		query.append(", (SELECT /*+ INDEX_DESC(H XAK1MST_CNTR_STS_HIS) */ AGMT_SEQ FROM MST_CNTR_STS_HIS H WHERE CNTR_NO =  @[cntr_no] AND CNTR_STS_CD = 'SRO' AND ROWNUM = 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", DECODE(@[st_cd],'0', 'LSO', '1', 'SBO', '2', 'SBI', '3', 'MUO', '4', 'MUI','5', 'SRO','6', 'SRI' ,'7', 'LSO')" ).append("\n"); 
		query.append(", @[ofc_cd]  " ).append("\n"); 
		query.append(", TO_DATE(@[hire_date],'YYYY-MM-DD') " ).append("\n"); 
		query.append("#if (${st_cd} == '1' || ${st_cd} == '3'|| ${st_cd} == '5' || ${st_cd} == '7')" ).append("\n"); 
		query.append("#if (${cntr_pkup_chg_amt} != '' && ${cntr_pkup_chg_amt} != '0' && ${cntr_pkup_chg_amt} != '0.00') " ).append("\n"); 
		query.append(", @[cntr_pkup_chg_amt]" ).append("\n"); 
		query.append("#elseif (${cntr_pkup_cr_chg_amt} != ''  && ${cntr_pkup_cr_chg_amt} != '0' && ${cntr_pkup_cr_chg_amt} != '0.00')" ).append("\n"); 
		query.append(", @[cntr_pkup_cr_chg_amt] * -1" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append(", 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", @[cntr_lft_chg_cur]" ).append("\n"); 
		query.append("#if (${st_cd} == '0' || ${st_cd} == '2' || ${st_cd} == '4' || ${st_cd} == '6')" ).append("\n"); 
		query.append("#if (${cntr_drff_amt} != '' && ${cntr_drff_amt} != '0' && ${cntr_drff_amt} != '0.00') " ).append("\n"); 
		query.append(", @[cntr_drff_amt]" ).append("\n"); 
		query.append("#elseif (${cntr_drff_cr_amt} != ''  && ${cntr_drff_cr_amt} != '0' && ${cntr_drff_cr_amt} != '0.00')" ).append("\n"); 
		query.append(", TO_NUMBER(@[cntr_drff_cr_amt]) * -1" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append(", 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${st_cd} == '0' || ${st_cd} == '2' || ${st_cd} == '4' || ${st_cd} == '6' || ${st_cd} == '7')" ).append("\n"); 
		query.append(", (SELECT YD_CD" ).append("\n"); 
		query.append("   FROM MST_CNTR_STS_HIS A" ).append("\n"); 
		query.append("   WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND   CNTR_STS_SEQ =(SELECT /*+ INDEX_DESC (B XAK1MST_CNTR_STS_HIS) */  B.CNTR_STS_SEQ" ).append("\n"); 
		query.append("                     FROM MST_CNTR_STS_HIS B" ).append("\n"); 
		query.append("                     WHERE A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("				#if (${st_cd} == '0')" ).append("\n"); 
		query.append("					 AND   B.CNTR_STS_CD IN ('LSI','DII')" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					AND   B.CNTR_STS_CD = DECODE(@[st_cd],'0', 'LSI', '2', 'SBO', '4', 'MUO','6', 'SRO','7', 'LSI')" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("                     AND   ROWNUM =1))" ).append("\n"); 
		query.append(", (SELECT CNTR_STS_SEQ" ).append("\n"); 
		query.append("   FROM MST_CNTR_STS_HIS A" ).append("\n"); 
		query.append("   WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND   CNTR_STS_SEQ =(SELECT /*+ INDEX_DESC (B XAK1MST_CNTR_STS_HIS) */  B.CNTR_STS_SEQ" ).append("\n"); 
		query.append("                     FROM MST_CNTR_STS_HIS B" ).append("\n"); 
		query.append("                     WHERE A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("				#if (${st_cd} == '0')" ).append("\n"); 
		query.append("					 AND   B.CNTR_STS_CD IN ('LSI','DII')" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					 AND   B.CNTR_STS_CD = DECODE(@[st_cd],'0', 'LSI', '2', 'SBO', '4', 'MUO', '6', 'SRO','7', 'LSI')" ).append("\n"); 
		query.append("				#end					 " ).append("\n"); 
		query.append("                     AND   ROWNUM =1))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", @[cntr_rmk]    " ).append("\n"); 
		query.append(", @[cnmv_sts_cd] " ).append("\n"); 
		query.append(", DECODE(@[full_flg],'F','Y','N')" ).append("\n"); 
		query.append(", @[cre_usr_id]  " ).append("\n"); 
		query.append(", SYSDATE        " ).append("\n"); 
		query.append(", @[upd_usr_id]  " ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[rntl_chg_free_dys]" ).append("\n"); 
		query.append(", @[cntr_lft_chg_amt]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}