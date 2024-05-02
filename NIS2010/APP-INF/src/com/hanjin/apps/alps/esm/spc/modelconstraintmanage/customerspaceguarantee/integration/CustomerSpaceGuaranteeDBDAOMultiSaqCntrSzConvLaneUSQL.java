/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomerSpaceGuaranteeDBDAOMultiSaqCntrSzConvLaneUSQL.java
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

public class CustomerSpaceGuaranteeDBDAOMultiSaqCntrSzConvLaneUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lane,선사별, Type Size 예외사항에 대한 UPDATE
	  * </pre>
	  */
	public CustomerSpaceGuaranteeDBDAOMultiSaqCntrSzConvLaneUSQL(){
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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("teu_40ft_conv_rto",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelconstraintmanage.customerspaceguarantee.integration").append("\n"); 
		query.append("FileName : CustomerSpaceGuaranteeDBDAOMultiSaqCntrSzConvLaneUSQL").append("\n"); 
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
		query.append("UPDATE SAQ_CNTR_SZ_CONV_LANE" ).append("\n"); 
		query.append("   SET RLANE_CD                 = @[rlane_cd]                ," ).append("\n"); 
		query.append("       DIR_CD                   = @[dir_cd]                  ," ).append("\n"); 
		query.append("       CRR_CD                   = @[crr_cd]                  ," ).append("\n"); 
		query.append("       TEU_20FT_CONV_RTO        = @[teu_20ft_conv_rto]       ," ).append("\n"); 
		query.append("       TEU_40FT_CONV_RTO        = @[teu_40ft_conv_rto]       ," ).append("\n"); 
		query.append("       TEU_40FT_HC_CONV_RTO     = @[teu_40ft_hc_conv_rto]    ," ).append("\n"); 
		query.append("       TEU_45FT_HC_CONV_RTO     = @[teu_45ft_hc_conv_rto]    ," ).append("\n"); 
		query.append("       OVR_TEU_20FT_CONV_RTO    = @[ovr_teu_20ft_conv_rto]   ," ).append("\n"); 
		query.append("       OVR_TEU_40FT_CONV_RTO    = @[ovr_teu_40ft_conv_rto]   ," ).append("\n"); 
		query.append("       OVR_TEU_40FT_HC_CONV_RTO = @[ovr_teu_40ft_hc_conv_rto]," ).append("\n"); 
		query.append("       OVR_TEU_45FT_HC_CONV_RTO = @[ovr_teu_45ft_hc_conv_rto]," ).append("\n"); 
		query.append("       UPD_USR_ID               = @[upd_usr_id]              ," ).append("\n"); 
		query.append("       UPD_DT                   = SYSDATE" ).append("\n"); 
		query.append(" WHERE RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("   AND DIR_CD   = @[dir_cd]" ).append("\n"); 
		query.append("   AND CRR_CD   = @[crr_cd]" ).append("\n"); 

	}
}