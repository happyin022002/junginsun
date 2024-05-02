/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOAddLeasedCntrStatusHistoryDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.07
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.03.07 이주현
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

public class ContainerOnOffhireDBDAOAddLeasedCntrStatusHistoryDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Insert MST_CNTR_STS_HIS
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOAddLeasedCntrStatusHistoryDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("sts_evnt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("min_onh_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_chg_cr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("his_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("cntr_old_van_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("free_dys",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("approval_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_chg_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lift_on_chrg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOAddLeasedCntrStatusHistoryDataCSQL").append("\n"); 
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
		query.append("	CNTR_NO" ).append("\n"); 
		query.append(",	CNTR_STS_SEQ" ).append("\n"); 
		query.append(",	CO_CD" ).append("\n"); 
		query.append(",	YD_CD" ).append("\n"); 
		query.append(",	LOC_CD" ).append("\n"); 
		query.append(",	AGMT_CTY_CD" ).append("\n"); 
		query.append(",	AGMT_SEQ" ).append("\n"); 
		query.append(",	CNTR_STS_CD" ).append("\n"); 
		query.append(",	OFC_CD" ).append("\n"); 
		query.append(",	CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append(",	CNTR_PKUP_CHG_AMT" ).append("\n"); 
		query.append(",	CURR_CD" ).append("\n"); 
		query.append(",	CNTR_LFT_CHG_AMT" ).append("\n"); 
		query.append(",	RNTL_CHG_FREE_DYS" ).append("\n"); 
		query.append(",	CNMV_STS_CD" ).append("\n"); 
		query.append(",	CNTR_FULL_FLG" ).append("\n"); 
		query.append(",	CNTR_FREE_DY_EXP_DT" ).append("\n"); 
		query.append(",	CNTR_OLD_VAN_FLG" ).append("\n"); 
		query.append(",	CNTR_MIN_ONH_DYS" ).append("\n"); 
		query.append(",	CNTR_AUTH_NO" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",   SCC_CD" ).append("\n"); 
		query.append(",   ECC_CD" ).append("\n"); 
		query.append(",   LCC_CD" ).append("\n"); 
		query.append(",   RCC_CD" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[cntr_no]" ).append("\n"); 
		query.append(",	@[his_seq]" ).append("\n"); 
		query.append(",	'O'" ).append("\n"); 
		query.append(",	@[sts_evnt_yd_cd]" ).append("\n"); 
		query.append(",	SUBSTR(@[sts_evnt_yd_cd], 1, 5)" ).append("\n"); 
		query.append(",	@[agmt_cty_cd]" ).append("\n"); 
		query.append(",	@[agmt_seq]" ).append("\n"); 
		query.append(",	'LSI'" ).append("\n"); 
		query.append(",	@[ofc_cd]" ).append("\n"); 
		query.append(",	TO_DATE(SUBSTR(@[hire_date], 1, 10),'YYYY-MM-DD')" ).append("\n"); 
		query.append("#if (${pkup_chg_amt} != '' && ${pkup_chg_amt} != '0' && ${pkup_chg_amt} != '0.00') " ).append("\n"); 
		query.append(",	@[pkup_chg_amt]" ).append("\n"); 
		query.append("#elseif (${pkup_chg_cr_amt} != ''  && ${pkup_chg_cr_amt} != '0' && ${pkup_chg_cr_amt} != '0.00')" ).append("\n"); 
		query.append(",	@[pkup_chg_cr_amt] * -1" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",   0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	'USD'" ).append("\n"); 
		query.append(",	@[lift_on_chrg]" ).append("\n"); 
		query.append(",	@[free_dys]" ).append("\n"); 
		query.append(",	'MT'" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append(",	TRUNC(TO_DATE(SUBSTR(@[hire_date], 1, 10),'YYYY-MM-DD')) + @[free_dys] - 1" ).append("\n"); 
		query.append(",	DECODE(SUBSTR(UPPER(@[cntr_old_van_flg]), 1,1),'O','Y','N')" ).append("\n"); 
		query.append(",	@[min_onh_dys]" ).append("\n"); 
		query.append(",	@[approval_no]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",   (SELECT A.SCC_CD FROM MDM_LOCATION A,MDM_EQ_ORZ_CHT B WHERE A.LOC_CD = SUBSTR(@[sts_evnt_yd_cd], 1, 5) AND   A.SCC_CD = B.SCC_CD)" ).append("\n"); 
		query.append(",   (SELECT B.ECC_CD FROM MDM_LOCATION A,MDM_EQ_ORZ_CHT B WHERE A.LOC_CD = SUBSTR(@[sts_evnt_yd_cd], 1, 5) AND   A.SCC_CD = B.SCC_CD)" ).append("\n"); 
		query.append(",   (SELECT B.LCC_CD FROM MDM_LOCATION A,MDM_EQ_ORZ_CHT B WHERE A.LOC_CD = SUBSTR(@[sts_evnt_yd_cd], 1, 5) AND   A.SCC_CD = B.SCC_CD)" ).append("\n"); 
		query.append(",   (SELECT B.RCC_CD FROM MDM_LOCATION A,MDM_EQ_ORZ_CHT B WHERE A.LOC_CD = SUBSTR(@[sts_evnt_yd_cd], 1, 5) AND   A.SCC_CD = B.SCC_CD)" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}