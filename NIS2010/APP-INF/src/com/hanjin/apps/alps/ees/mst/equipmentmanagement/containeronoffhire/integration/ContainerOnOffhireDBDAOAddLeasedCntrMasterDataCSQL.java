/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOAddLeasedCntrMasterDataCSQL.java
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

public class ContainerOnOffhireDBDAOAddLeasedCntrMasterDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Insert Leased Cntr Master Data
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOAddLeasedCntrMasterDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("hire_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts_evnt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("cntr_spec_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("his_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mft_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_abbr_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_mtrl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOAddLeasedCntrMasterDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MST_CONTAINER (" ).append("\n"); 
		query.append("	CNTR_NO" ).append("\n"); 
		query.append(",	SYS_AREA_GRP_ID" ).append("\n"); 
		query.append(",	AGMT_CTY_CD" ).append("\n"); 
		query.append(",	AGMT_SEQ" ).append("\n"); 
		query.append(",	VNDR_SEQ" ).append("\n"); 
		query.append(",	ONH_CNTR_STS_CD" ).append("\n"); 
		query.append(",	ONH_DT" ).append("\n"); 
		query.append(",	ONH_YD_CD" ).append("\n"); 
		query.append(",	ONH_FREE_DYS" ).append("\n"); 
		query.append(",	CNTR_MTRL_CD" ).append("\n"); 
		query.append(",	CNMV_DT" ).append("\n"); 
		query.append(",	FULL_FLG" ).append("\n"); 
		query.append(",	CNTR_STS_CD" ).append("\n"); 
		query.append(",	LST_STS_YD_CD" ).append("\n"); 
		query.append(",	LST_STS_SEQ" ).append("\n"); 
		query.append(",	CRNT_YD_CD" ).append("\n"); 
		query.append(",	LOC_CD" ).append("\n"); 
		query.append(",	CNMV_STS_CD" ).append("\n"); 
		query.append(",	ACIAC_DIV_CD" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	LSTM_CD" ).append("\n"); 
		query.append(",	MFTR_VNDR_SEQ" ).append("\n"); 
		query.append(",	MFT_DT" ).append("\n"); 
		query.append(",	HJS_CRE_FLG" ).append("\n"); 
		query.append(",	OWNR_CO_CD" ).append("\n"); 
		query.append(",	MIN_ONH_DYS" ).append("\n"); 
		query.append(",	CNTR_AUTH_NO" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",   ONH_STS_SEQ" ).append("\n"); 
		query.append(",   SCC_CD" ).append("\n"); 
		query.append(",   ECC_CD" ).append("\n"); 
		query.append(",   LCC_CD" ).append("\n"); 
		query.append(",   RCC_CD" ).append("\n"); 
		query.append(",   CNTR_USE_CO_CD" ).append("\n"); 
		query.append(",   CNTR_SPEC_NO" ).append("\n"); 
		query.append("#if (${rf_tp_cd} != '')" ).append("\n"); 
		query.append(",   RF_TP_CD " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[cntr_no]" ).append("\n"); 
		query.append(",	'KOR'" ).append("\n"); 
		query.append(",	@[agmt_cty_cd]" ).append("\n"); 
		query.append(",	@[agmt_seq]" ).append("\n"); 
		query.append(",	@[vndr_seq]" ).append("\n"); 
		query.append(",	'LSI'" ).append("\n"); 
		query.append(",	TO_DATE(@[hire_date],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	@[sts_evnt_yd_cd]" ).append("\n"); 
		query.append(",	@[free_dys]" ).append("\n"); 
		query.append(",	@[cntr_mtrl_cd]" ).append("\n"); 
		query.append(",	TO_DATE(@[hire_date],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append(",	'LSI'" ).append("\n"); 
		query.append(",	@[sts_evnt_yd_cd]" ).append("\n"); 
		query.append(",	@[his_seq]" ).append("\n"); 
		query.append(",	@[sts_evnt_yd_cd]" ).append("\n"); 
		query.append(",	SUBSTR(@[sts_evnt_yd_cd], 1, 5)" ).append("\n"); 
		query.append(",	'MT'" ).append("\n"); 
		query.append(",	'A'" ).append("\n"); 
		query.append(",	@[eq_tpsz_cd]" ).append("\n"); 
		query.append(",	@[lstm_cd]" ).append("\n"); 
		query.append(",	@[vndr_abbr_nm]" ).append("\n"); 
		query.append(",	TO_DATE(@[mft_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append(",	'H'" ).append("\n"); 
		query.append(",	@[min_onh_dys]" ).append("\n"); 
		query.append(",	@[approval_no]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[his_seq]" ).append("\n"); 
		query.append(",   (SELECT A.SCC_CD FROM MDM_LOCATION A,MDM_EQ_ORZ_CHT B WHERE A.LOC_CD = SUBSTR(@[sts_evnt_yd_cd], 1, 5) AND   A.SCC_CD = B.SCC_CD)" ).append("\n"); 
		query.append(",   (SELECT B.ECC_CD FROM MDM_LOCATION A,MDM_EQ_ORZ_CHT B WHERE A.LOC_CD = SUBSTR(@[sts_evnt_yd_cd], 1, 5) AND   A.SCC_CD = B.SCC_CD)" ).append("\n"); 
		query.append(",   (SELECT B.LCC_CD FROM MDM_LOCATION A,MDM_EQ_ORZ_CHT B WHERE A.LOC_CD = SUBSTR(@[sts_evnt_yd_cd], 1, 5) AND   A.SCC_CD = B.SCC_CD)" ).append("\n"); 
		query.append(",   (SELECT B.RCC_CD FROM MDM_LOCATION A,MDM_EQ_ORZ_CHT B WHERE A.LOC_CD = SUBSTR(@[sts_evnt_yd_cd], 1, 5) AND   A.SCC_CD = B.SCC_CD)" ).append("\n"); 
		query.append(",   'H'" ).append("\n"); 
		query.append(",   @[cntr_spec_no]" ).append("\n"); 
		query.append("#if (${rf_tp_cd} != '')" ).append("\n"); 
		query.append(",   @[rf_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}