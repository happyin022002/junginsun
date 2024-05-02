/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DemDetTariffMgtDBDAOAddApproSetupInfoListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.08
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DemDetTariffMgtDBDAOAddApproSetupInfoListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DemDetTariffMgtDBDAOAddApproSetupInfoListCSQL
	  * </pre>
	  */
	public DemDetTariffMgtDBDAOAddApproSetupInfoListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_expt_apro_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_rhq_subst_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_rhq_pic_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ft_add_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ft_ttl_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_brnc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_brnc_subst_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_ho_subst_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_ho_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_lvl",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dmdt_rhq_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dc_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dc_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration").append("\n"); 
		query.append("FileName : DemDetTariffMgtDBDAOAddApproSetupInfoListCSQL").append("\n"); 
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
		query.append("MERGE INTO DMT_APRO_STUP" ).append("\n"); 
		query.append("USING DUAL" ).append("\n"); 
		query.append("ON    (     DMDT_EXPT_APRO_TP_CD = @[dmdt_expt_apro_tp_cd]" ).append("\n"); 
		query.append("AND   OFC_LVL = @[ofc_lvl]" ).append("\n"); 
		query.append("AND   DMDT_OFC_CD = @[dmdt_ofc_cd]" ).append("\n"); 
		query.append("AND   DMDT_SEQ = @[dmdt_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("FT_ADD_DYS				= @[ft_add_dys]" ).append("\n"); 
		query.append(",FT_TTL_DYS				= @[ft_ttl_dys]" ).append("\n"); 
		query.append(",DC_FLG					= DECODE(@[dc_flg],'1','Y','N')" ).append("\n"); 
		query.append(",DC_RTO					= @[dc_rto]" ).append("\n"); 
		query.append(",DC_AMT					= @[dc_amt]" ).append("\n"); 
		query.append(",DMDT_BRNC_FLG			=  DECODE(@[dmdt_brnc_flg],'1','Y','N')" ).append("\n"); 
		query.append(",DMDT_BRNC_SUBST_ID		= @[dmdt_brnc_subst_id]" ).append("\n"); 
		query.append(",DMDT_RHQ_PIC_FLG		=  DECODE(@[dmdt_rhq_pic_flg],'1','Y','N')" ).append("\n"); 
		query.append(",DMDT_RHQ_FLG			=  DECODE(@[dmdt_rhq_flg],'1','Y','N')" ).append("\n"); 
		query.append(",DMDT_RHQ_SUBST_ID		= @[dmdt_rhq_subst_id]" ).append("\n"); 
		query.append(",DMDT_HO_FLG			=  DECODE(@[dmdt_ho_flg],'1','Y','N')" ).append("\n"); 
		query.append(",DMDT_HO_SUBST_ID		= @[dmdt_ho_subst_id]" ).append("\n"); 
		query.append(",UPD_DT       			= SYSDATE" ).append("\n"); 
		query.append(",UPD_USR_ID   			= @[upd_usr_id]" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("DMDT_EXPT_APRO_TP_CD" ).append("\n"); 
		query.append(",OFC_LVL" ).append("\n"); 
		query.append(",DMDT_OFC_CD" ).append("\n"); 
		query.append(",DMDT_SEQ" ).append("\n"); 
		query.append(",CUST_CNT_CD" ).append("\n"); 
		query.append(",CUST_SEQ" ).append("\n"); 
		query.append(",FT_ADD_DYS" ).append("\n"); 
		query.append(",FT_TTL_DYS" ).append("\n"); 
		query.append(",DC_FLG" ).append("\n"); 
		query.append(",DC_RTO" ).append("\n"); 
		query.append(",DC_AMT" ).append("\n"); 
		query.append(",DMDT_BRNC_FLG" ).append("\n"); 
		query.append(",DMDT_BRNC_SUBST_ID" ).append("\n"); 
		query.append(",DMDT_RHQ_PIC_FLG" ).append("\n"); 
		query.append(",DMDT_RHQ_FLG" ).append("\n"); 
		query.append(",DMDT_RHQ_SUBST_ID" ).append("\n"); 
		query.append(",DMDT_HO_FLG" ).append("\n"); 
		query.append(",DMDT_HO_SUBST_ID" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[dmdt_expt_apro_tp_cd]" ).append("\n"); 
		query.append(",@[ofc_lvl]" ).append("\n"); 
		query.append(",@[dmdt_ofc_cd]" ).append("\n"); 
		query.append(",NVL(( SELECT MAX(DMDT_SEQ)+1 FROM DMT_APRO_STUP" ).append("\n"); 
		query.append("WHERE DMDT_EXPT_APRO_TP_CD = @[dmdt_expt_apro_tp_cd]" ).append("\n"); 
		query.append("AND OFC_LVL = @[ofc_lvl]" ).append("\n"); 
		query.append("AND DMDT_OFC_CD = @[dmdt_ofc_cd] ),1)" ).append("\n"); 
		query.append(",CASE WHEN TRIM(UPPER(@[cust_cd])) = 'ALL' THEN 'AL'" ).append("\n"); 
		query.append("ELSE SUBSTR(@[cust_cd],1,2) END" ).append("\n"); 
		query.append(",CASE WHEN TRIM(UPPER(@[cust_cd])) = 'ALL' THEN 0" ).append("\n"); 
		query.append("ELSE TO_NUMBER(SUBSTR(@[cust_cd],3)) END" ).append("\n"); 
		query.append(",@[ft_add_dys]" ).append("\n"); 
		query.append(",@[ft_ttl_dys]" ).append("\n"); 
		query.append(",DECODE(@[dc_flg],'1','Y','N')" ).append("\n"); 
		query.append(",@[dc_rto]" ).append("\n"); 
		query.append(",@[dc_amt]" ).append("\n"); 
		query.append(",DECODE(@[dmdt_brnc_flg],'1','Y','N')" ).append("\n"); 
		query.append(",@[dmdt_brnc_subst_id]" ).append("\n"); 
		query.append(",DECODE(@[dmdt_rhq_pic_flg],'1','Y','N')" ).append("\n"); 
		query.append(",DECODE(@[dmdt_rhq_flg],'1','Y','N')" ).append("\n"); 
		query.append(",@[dmdt_rhq_subst_id]" ).append("\n"); 
		query.append(",DECODE(@[dmdt_ho_flg],'1','Y','N')" ).append("\n"); 
		query.append(",@[dmdt_ho_subst_id]" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}