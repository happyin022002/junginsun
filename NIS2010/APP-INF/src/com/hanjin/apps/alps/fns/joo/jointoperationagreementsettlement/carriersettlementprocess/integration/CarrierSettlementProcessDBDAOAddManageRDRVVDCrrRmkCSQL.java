/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOAddManageRDRVVDCrrRmkCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.24
*@LastModifier : 
*@LastVersion : 1.0
* 2011.01.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOAddManageRDRVVDCrrRmkCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * --------------------------------------------------------
	  * History
	  * 2011.01.11 김상수 [CHM-201007350-01] JOO - RDR Inquiry by Lane 기능 보완 요청
	  *                   1. 보완 대상
	  *                      가. 조회  Option
	  *                         - Region Multi 선택
	  *                         - Carrier 추가 - Multi 선택
	  *                      나. Remark Pop up 추가 - 일부 Data 저장 및 해당 컬럼에 반영 (계산 Logic 포함)
	  *                      다. Asjusted Allocation 컬럼 추가 (계산Logic 포함)
	  *                      라. Over Used 계산 Logic( Allocation 참조 컬럼을  Adjusted Allocation으로 변경
	  *                      마. 기타 : 컬럼별 계산 Logic 수정
	  * 2011.01.20 김상수 [CHM-201108389-01] RDR Inquiry by Lane 추가 기능 개발
	  *                    - Slot Release TEU, WT에 사용자가 입력하는 Data를 반영할 수 있도록 보완
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOAddManageRDRVVDCrrRmkCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("region",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_void_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_rf_ipt_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_slt_rlse_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_shrt_leg_rmk_diff_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("swap_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_shrt_leg_rmk_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("opr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_shrt_leg_rmk_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_rf_ocn_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("swap_slot",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOAddManageRDRVVDCrrRmkCSQL").append("\n"); 
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
		query.append("INSERT INTO JOO_RDR_VVD_CRR_RMK" ).append("\n"); 
		query.append("       (VSL_CD," ).append("\n"); 
		query.append("        SKD_VOY_NO," ).append("\n"); 
		query.append("        SKD_DIR_CD," ).append("\n"); 
		query.append("        JO_RGN_CD," ).append("\n"); 
		query.append("        PORT_CD," ).append("\n"); 
		query.append("        JO_CRR_CD," ).append("\n"); 
		query.append("        JO_VOID_TEU_QTY," ).append("\n"); 
		query.append("        JO_SLT_RLSE_CD," ).append("\n"); 
		query.append("        JO_SHRT_LEG_RMK_TEU_QTY," ).append("\n"); 
		query.append("        JO_SHRT_LEG_RMK_WGT," ).append("\n"); 
		query.append("        JO_SHRT_LEG_RMK_DIFF_QTY," ).append("\n"); 
		query.append("        JO_RF_OCN_QTY," ).append("\n"); 
		query.append("        JO_RF_IPT_QTY," ).append("\n"); 
		query.append("        JO_SLT_RLSE_TEU_QTY," ).append("\n"); 
		query.append("        JO_SLT_RLSE_WGT," ).append("\n"); 
		query.append("        CRE_USR_ID," ).append("\n"); 
		query.append("        CRE_DT," ).append("\n"); 
		query.append("        UPD_USR_ID," ).append("\n"); 
		query.append("        UPD_DT)" ).append("\n"); 
		query.append("VALUES (@[vsl_cd]," ).append("\n"); 
		query.append("        @[voy_no]," ).append("\n"); 
		query.append("        @[dir_cd]," ).append("\n"); 
		query.append("        @[region]," ).append("\n"); 
		query.append("        @[port_cd]," ).append("\n"); 
		query.append("        @[opr_cd]," ).append("\n"); 
		query.append("        @[jo_void_teu_qty]," ).append("\n"); 
		query.append("        @[jo_slt_rlse_cd]," ).append("\n"); 
		query.append("        @[jo_shrt_leg_rmk_teu_qty]," ).append("\n"); 
		query.append("        @[jo_shrt_leg_rmk_wgt]," ).append("\n"); 
		query.append("        @[jo_shrt_leg_rmk_diff_qty]," ).append("\n"); 
		query.append("        @[jo_rf_ocn_qty]," ).append("\n"); 
		query.append("        @[jo_rf_ipt_qty]," ).append("\n"); 
		query.append("        @[swap_slot]," ).append("\n"); 
		query.append("        @[swap_wgt]," ).append("\n"); 
		query.append("        @[usr_id]," ).append("\n"); 
		query.append("        SYSDATE," ).append("\n"); 
		query.append("        @[usr_id]," ).append("\n"); 
		query.append("        SYSDATE)" ).append("\n"); 

	}
}