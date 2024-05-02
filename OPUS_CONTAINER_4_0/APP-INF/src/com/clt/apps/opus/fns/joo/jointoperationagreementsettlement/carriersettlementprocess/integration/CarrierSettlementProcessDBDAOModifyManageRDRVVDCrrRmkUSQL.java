/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOModifyManageRDRVVDCrrRmkUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.11
*@LastModifier : 
*@LastVersion : 1.0
* 2011.01.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOModifyManageRDRVVDCrrRmkUSQL implements ISQLTemplate{

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
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOModifyManageRDRVVDCrrRmkUSQL(){
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
		params.put("jo_shrt_leg_rmk_diff_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOModifyManageRDRVVDCrrRmkUSQL").append("\n"); 
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
		query.append("UPDATE JOO_RDR_VVD_CRR_RMK" ).append("\n"); 
		query.append("   SET JO_VOID_TEU_QTY = @[jo_void_teu_qty]," ).append("\n"); 
		query.append("       JO_SLT_RLSE_CD = @[jo_slt_rlse_cd]," ).append("\n"); 
		query.append("       JO_SHRT_LEG_RMK_TEU_QTY= @[jo_shrt_leg_rmk_teu_qty]," ).append("\n"); 
		query.append("       JO_SHRT_LEG_RMK_WGT = @[jo_shrt_leg_rmk_wgt]," ).append("\n"); 
		query.append("       JO_SHRT_LEG_RMK_DIFF_QTY = @[jo_shrt_leg_rmk_diff_qty]," ).append("\n"); 
		query.append("       JO_RF_OCN_QTY = @[jo_rf_ocn_qty]," ).append("\n"); 
		query.append("       JO_RF_IPT_QTY = @[jo_rf_ipt_qty]," ).append("\n"); 
		query.append("       UPD_USR_ID = @[usr_id]," ).append("\n"); 
		query.append("       UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("   AND SKD_VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("   AND SKD_DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("   AND JO_RGN_CD = @[region]" ).append("\n"); 
		query.append("   AND PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("   AND JO_CRR_CD = @[opr_cd]" ).append("\n"); 

	}
}