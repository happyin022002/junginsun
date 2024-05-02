/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepoThresholdManageDBDAOSearchCntrInputDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.10.16 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.repothresholdmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepoThresholdManageDBDAOSearchCntrInputDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eqr_inp_dat_red_lgt_alt 테이블의 데이터 조회
	  * </pre>
	  */
	public RepoThresholdManageDBDAOSearchCntrInputDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intg_cd_id_1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intg_cd_id_2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.defaultmanage.repothresholdmanage.integration").append("\n"); 
		query.append("FileName : RepoThresholdManageDBDAOSearchCntrInputDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("MAX(RLA_TP_CD)   as ALT_ITM_DIV_CD" ).append("\n"); 
		query.append(",MAX(TYPE2)	     as CNTR_SZ_CD" ).append("\n"); 
		query.append(",TYPE1_DESC	     as RCC_DESC" ).append("\n"); 
		query.append(",MAX(TYPE2)	     as CNTR_SZ_CD_DISPLAY" ).append("\n"); 
		query.append(",MAX(USNYC_COST) as ALT_COST_AMT_USNYC" ).append("\n"); 
		query.append(",MAX(USNYC_BSE)  as ALT_BSE_CD_USNYC" ).append("\n"); 
		query.append(",MAX(DEHAM_COST) as ALT_COST_AMT_DEHAM" ).append("\n"); 
		query.append(",MAX(DEHAM_BSE)  as ALT_BSE_CD_DEHAM" ).append("\n"); 
		query.append(",MAX(SGSIN_COST) as ALT_COST_AMT_SGSIN" ).append("\n"); 
		query.append(",MAX(SGSIN_BSE)  as ALT_BSE_CD_SGSIN" ).append("\n"); 
		query.append(",MAX(KRSEL_COST) as ALT_COST_AMT_KRSEL" ).append("\n"); 
		query.append(",MAX(KRSEL_BSE)  as ALT_BSE_CD_KRSEL" ).append("\n"); 
		query.append(",MAX(CNHKG_COST) as ALT_COST_AMT_CNHKG" ).append("\n"); 
		query.append(",MAX(CNHKG_BSE)  as ALT_BSE_CD_CNHKG" ).append("\n"); 
		query.append(",MAX(CNSHA_COST) as ALT_COST_AMT_CNSHA" ).append("\n"); 
		query.append(",MAX(CNSHA_BSE)  as ALT_BSE_CD_CNSHA" ).append("\n"); 
		query.append(",MAX(JPTYO_COST) as ALT_COST_AMT_JPTYO" ).append("\n"); 
		query.append(",MAX(JPTYO_BSE)	 as ALT_BSE_CD_JPTYO" ).append("\n"); 
		query.append(",MAX(TWTPE_COST) as ALT_COST_AMT_TWTPE" ).append("\n"); 
		query.append(",MAX(TWTPE_BSE)  as ALT_BSE_CD_TWTPE" ).append("\n"); 
		query.append(",MAX(TYPE1NUM)" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("RCC" ).append("\n"); 
		query.append(",TYPE1_DESC" ).append("\n"); 
		query.append(",TYPE1_CODE RLA_TP_CD" ).append("\n"); 
		query.append(",TYPE2" ).append("\n"); 
		query.append(",MAX(DECODE(RCC, 'USNYC', cost_amt))  USNYC_COST" ).append("\n"); 
		query.append(",MAX(DECODE(RCC, 'USNYC', bse_cd))  USNYC_BSE" ).append("\n"); 
		query.append(",MAX(DECODE(RCC, 'DEHAM', cost_amt))  DEHAM_COST" ).append("\n"); 
		query.append(",MAX(DECODE(RCC, 'DEHAM', bse_cd))  DEHAM_BSE" ).append("\n"); 
		query.append(",MAX(DECODE(RCC, 'SGSIN', cost_amt))  SGSIN_COST" ).append("\n"); 
		query.append(",MAX(DECODE(RCC, 'SGSIN', bse_cd))  SGSIN_BSE" ).append("\n"); 
		query.append(",MAX(DECODE(RCC, 'KRSEL', cost_amt))  KRSEL_COST" ).append("\n"); 
		query.append(",MAX(DECODE(RCC, 'KRSEL', bse_cd))  KRSEL_BSE" ).append("\n"); 
		query.append(",MAX(DECODE(RCC, 'CNHKG', cost_amt))  CNHKG_COST" ).append("\n"); 
		query.append(",MAX(DECODE(RCC, 'CNHKG', bse_cd))  CNHKG_BSE" ).append("\n"); 
		query.append(",MAX(DECODE(RCC, 'CNSHA', cost_amt))  CNSHA_COST" ).append("\n"); 
		query.append(",MAX(DECODE(RCC, 'CNSHA', bse_cd))  CNSHA_BSE" ).append("\n"); 
		query.append(",MAX(DECODE(RCC, 'JPTYO', cost_amt))  JPTYO_COST" ).append("\n"); 
		query.append(",MAX(DECODE(RCC, 'JPTYO', bse_cd))  JPTYO_BSE" ).append("\n"); 
		query.append(",MAX(DECODE(RCC, 'TWTPE', cost_amt))  TWTPE_COST" ).append("\n"); 
		query.append(",MAX(DECODE(RCC, 'TWTPE', bse_cd))  TWTPE_BSE" ).append("\n"); 
		query.append(",RCCNUM" ).append("\n"); 
		query.append(",TYPE1NUM" ).append("\n"); 
		query.append(",TYPE2NUM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.RCC RCC" ).append("\n"); 
		query.append(",A.TYPE1_CODE TYPE1_CODE" ).append("\n"); 
		query.append(",A.TYPE1_DESC TYPE1_DESC" ).append("\n"); 
		query.append(",A.TYPE2 TYPE2" ).append("\n"); 
		query.append(",B.cntr_sz_cd cntr_cd" ).append("\n"); 
		query.append(",B.alt_cost_amt cost_amt" ).append("\n"); 
		query.append(",B.alt_bse_cd bse_cd" ).append("\n"); 
		query.append(",A.RCCNUM" ).append("\n"); 
		query.append(",A.TYPE1NUM" ).append("\n"); 
		query.append(",A.TYPE2NUM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.intg_cd_val_dp_desc RCC" ).append("\n"); 
		query.append(",B.intg_cd_val_ctnt    TYPE1_CODE" ).append("\n"); 
		query.append(",B.intg_cd_val_dp_desc TYPE1_DESC" ).append("\n"); 
		query.append(",C.PARAM               TYPE2" ).append("\n"); 
		query.append(",A.intg_cd_val_dp_seq  RCCNUM" ).append("\n"); 
		query.append(",B.NUM                 TYPE1NUM" ).append("\n"); 
		query.append(",C.NUM                 TYPE2NUM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("com_intg_cd_dtl A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("intg_cd_val_ctnt" ).append("\n"); 
		query.append(",intg_cd_val_dp_desc" ).append("\n"); 
		query.append(",intg_cd_val_dp_seq NUM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("com_intg_cd_dtl" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("intg_cd_id = @[intg_cd_id_1]" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("intg_cd_val_dp_seq" ).append("\n"); 
		query.append(") B," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT '20' param, 1 num FROM dual" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '40' param, 2 num FROM dual" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '45' param, 3 num FROM dual" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.intg_cd_id = @[intg_cd_id_2]" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("A.intg_cd_val_dp_seq" ).append("\n"); 
		query.append(",B.num" ).append("\n"); 
		query.append(",B.intg_cd_val_ctnt" ).append("\n"); 
		query.append(",C.num" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("eqr_inp_dat_red_lgt_alt B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.RCC = B.RCC_CD" ).append("\n"); 
		query.append("AND   A.TYPE1_CODE = B.alt_itm_div_cd" ).append("\n"); 
		query.append("AND   A.TYPE2 = B.cntr_sz_cd" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("RCC" ).append("\n"); 
		query.append(",TYPE1_CODE" ).append("\n"); 
		query.append(",TYPE1_DESC" ).append("\n"); 
		query.append(",TYPE2" ).append("\n"); 
		query.append(",RCCNUM" ).append("\n"); 
		query.append(",TYPE1NUM" ).append("\n"); 
		query.append(",TYPE2NUM" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("RCCNUM" ).append("\n"); 
		query.append(",TYPE1NUM" ).append("\n"); 
		query.append(",TYPE2NUM" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("RLA_TP_CD" ).append("\n"); 
		query.append(",TYPE1_DESC" ).append("\n"); 
		query.append(",TYPE2" ).append("\n"); 
		query.append(",TYPE1NUM" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("TYPE1NUM" ).append("\n"); 

	}
}