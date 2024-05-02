/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomerSpaceGuaranteeDBDAOMultiSaqCntrSzConvCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.03
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2010.02.03 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.customerspaceguarantee.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerSpaceGuaranteeDBDAOMultiSaqCntrSzConvCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Type Size 별 Teu Conversion INSERT
	  * </pre>
	  */
	public CustomerSpaceGuaranteeDBDAOMultiSaqCntrSzConvCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("teu_20ft_conv_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_own_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_teu_40ft_conv_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("teu_45ft_hc_conv_rto",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ovr_teu_40ft_hc_conv_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_teu_20ft_conv_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("teu_40ft_hc_conv_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_teu_45ft_hc_conv_rto",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("teu_40ft_conv_rto",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelconstraintmanage.customerspaceguarantee.integration").append("\n"); 
		query.append("FileName : CustomerSpaceGuaranteeDBDAOMultiSaqCntrSzConvCSQL").append("\n"); 
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
		query.append("INSERT INTO SAQ_CNTR_SZ_CONV (" ).append("\n"); 
		query.append("    VSL_OWN_IND_CD          ," ).append("\n"); 
		query.append("    TEU_20FT_CONV_RTO       ," ).append("\n"); 
		query.append("    TEU_40FT_CONV_RTO       ," ).append("\n"); 
		query.append("    TEU_40FT_HC_CONV_RTO    ," ).append("\n"); 
		query.append("    TEU_45FT_HC_CONV_RTO    ," ).append("\n"); 
		query.append("    OVR_TEU_20FT_CONV_RTO   ," ).append("\n"); 
		query.append("    OVR_TEU_40FT_CONV_RTO   ," ).append("\n"); 
		query.append("    OVR_TEU_40FT_HC_CONV_RTO," ).append("\n"); 
		query.append("    OVR_TEU_45FT_HC_CONV_RTO," ).append("\n"); 
		query.append("    CRE_USR_ID              ," ).append("\n"); 
		query.append("    CRE_DT                  ," ).append("\n"); 
		query.append("    UPD_USR_ID              ," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("    @[vsl_own_ind_cd]          ," ).append("\n"); 
		query.append("    @[teu_20ft_conv_rto]       ," ).append("\n"); 
		query.append("    @[teu_40ft_conv_rto]       ," ).append("\n"); 
		query.append("    @[teu_40ft_hc_conv_rto]    ," ).append("\n"); 
		query.append("    @[teu_45ft_hc_conv_rto]    ," ).append("\n"); 
		query.append("    @[ovr_teu_20ft_conv_rto]   ," ).append("\n"); 
		query.append("    @[ovr_teu_40ft_conv_rto]   ," ).append("\n"); 
		query.append("    @[ovr_teu_40ft_hc_conv_rto]," ).append("\n"); 
		query.append("    @[ovr_teu_45ft_hc_conv_rto]," ).append("\n"); 
		query.append("    @[cre_usr_id]              ," ).append("\n"); 
		query.append("    SYSDATE                    ," ).append("\n"); 
		query.append("    @[upd_usr_id]              ," ).append("\n"); 
		query.append("    SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}