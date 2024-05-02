/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PickupReturnCyManageDBDAOUpdatePickupReturnCyUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.pickupreturncy.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PickupReturnCyManageDBDAOUpdatePickupReturnCyUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UpdatePickupReturnCy
	  * 2010.10.1 채창호 CHM-201006135-01 Pick Up & Return CY Export 화면 수정 요청
	  * 내용: PRD_PKUP_RTN_YD 테이블의 FULL_PKUP_RTN_YD_CD 컬럼 삭제
	  * </pre>
	  */
	public PickupReturnCyManageDBDAOUpdatePickupReturnCyUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_sz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mty_pkup_rtn_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networknodemanage.pickupreturncy.integration").append("\n"); 
		query.append("FileName : PickupReturnCyManageDBDAOUpdatePickupReturnCyUSQL").append("\n"); 
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
		query.append("MERGE INTO PRD_PKUP_RTN_YD" ).append("\n"); 
		query.append("USING DUAL" ).append("\n"); 
		query.append("ON (POR_DEL_CD = @[por_del_cd] AND POL_POD_CD = @[pol_pod_cd] AND VSL_SLAN_CD = @[vsl_slan_cd] AND IO_BND_CD = @[io_bnd_cd] AND SPCL_CGO_CD = @[spcl_cgo_cd] AND CNTR_TP_CD = @[cntr_tp_cd] AND CNTR_SZ_CD = @[cntr_sz_cd])" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("  UPDATE" ).append("\n"); 
		query.append("     SET MTY_PKUP_RTN_YD_CD = @[mty_pkup_rtn_yd_cd]" ).append("\n"); 
		query.append("        ,UPD_USR_ID         = @[upd_usr_id]" ).append("\n"); 
		query.append("        ,UPD_DT             = SYSDATE" ).append("\n"); 
		query.append("        ,DELT_FLG           = DECODE(@[delt_flg], '1', 'Y', 'N')" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("  INSERT (" ).append("\n"); 
		query.append("     POR_DEL_CD" ).append("\n"); 
		query.append("    ,POL_POD_CD" ).append("\n"); 
		query.append("    ,VSL_SLAN_CD" ).append("\n"); 
		query.append("    ,IO_BND_CD" ).append("\n"); 
		query.append("    ,SPCL_CGO_CD" ).append("\n"); 
		query.append("    ,MTY_PKUP_RTN_YD_CD" ).append("\n"); 
		query.append("    ,CNTR_TP_CD" ).append("\n"); 
		query.append("    ,CNTR_SZ_CD" ).append("\n"); 
		query.append("    ,DELT_FLG" ).append("\n"); 
		query.append("    ,CRE_USR_ID" ).append("\n"); 
		query.append("    ,CRE_DT" ).append("\n"); 
		query.append("    ,UPD_USR_ID" ).append("\n"); 
		query.append("    ,UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("     @[por_del_cd]" ).append("\n"); 
		query.append("    ,@[pol_pod_cd]" ).append("\n"); 
		query.append("    ,@[vsl_slan_cd]" ).append("\n"); 
		query.append("    ,@[io_bnd_cd]" ).append("\n"); 
		query.append("    ,@[spcl_cgo_cd]" ).append("\n"); 
		query.append("    ,@[mty_pkup_rtn_yd_cd]" ).append("\n"); 
		query.append("    ,@[cntr_tp_cd]" ).append("\n"); 
		query.append("    ,@[cntr_sz_cd]" ).append("\n"); 
		query.append("    ,'N'" ).append("\n"); 
		query.append("    ,@[cre_usr_id]" ).append("\n"); 
		query.append("    ,SYSDATE" ).append("\n"); 
		query.append("    ,@[upd_usr_id]" ).append("\n"); 
		query.append("    ,SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}