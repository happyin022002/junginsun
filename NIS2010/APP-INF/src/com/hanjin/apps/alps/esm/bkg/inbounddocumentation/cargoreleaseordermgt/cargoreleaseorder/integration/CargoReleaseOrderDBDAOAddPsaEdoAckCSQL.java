/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOAddPsaEdoAckCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2011.08.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOAddPsaEdoAckCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSA EDO 승인 요청에 대한 처리 후 전송 결과(Ack)정보를 기록한다. 
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOAddPsaEdoAckCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("do_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("psa_do_rcv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_log_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("do_vsl_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("do_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("psa_auth_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("do_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOAddPsaEdoAckCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_PSA_EDO_RCV_LOG " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("   BL_NO" ).append("\n"); 
		query.append("  ,CNTR_NO" ).append("\n"); 
		query.append("  ,RCV_SEQ" ).append("\n"); 
		query.append("  ,DO_VSL_NM" ).append("\n"); 
		query.append("  ,DO_VSL_CD" ).append("\n"); 
		query.append("  ,DO_SKD_VOY_NO" ).append("\n"); 
		query.append("  ,DO_SKD_DIR_CD" ).append("\n"); 
		query.append("  ,PSA_DO_RCV_STS_CD" ).append("\n"); 
		query.append("  ,PSA_AUTH_NO" ).append("\n"); 
		query.append("  ,ERR_LOG_CTNT" ).append("\n"); 
		query.append("  ,RCV_DT" ).append("\n"); 
		query.append("  ,RCV_GDT" ).append("\n"); 
		query.append("  ,CRE_USR_ID" ).append("\n"); 
		query.append("  ,CRE_DT" ).append("\n"); 
		query.append("  ,UPD_USR_ID" ).append("\n"); 
		query.append("  ,UPD_DT" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT @[bl_no]," ).append("\n"); 
		query.append("       @[cntr_no]," ).append("\n"); 
		query.append("       (select nvl(max(rcv_seq)+1, 1) from BKG_PSA_EDO_RCV_LOG where bl_no = @[bl_no] and cntr_no = @[cntr_no])," ).append("\n"); 
		query.append("       @[do_vsl_nm]," ).append("\n"); 
		query.append("       @[do_vsl_cd]," ).append("\n"); 
		query.append("       @[do_skd_voy_no]," ).append("\n"); 
		query.append("       @[do_skd_dir_cd]," ).append("\n"); 
		query.append("       @[psa_do_rcv_sts_cd]," ).append("\n"); 
		query.append("       @[psa_auth_no]," ).append("\n"); 
		query.append("       @[err_log_ctnt]," ).append("\n"); 
		query.append("       sysdate," ).append("\n"); 
		query.append("       GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',sysdate,'GMT') ," ).append("\n"); 
		query.append("       @[cre_usr_id]," ).append("\n"); 
		query.append("       sysdate," ).append("\n"); 
		query.append("       @[upd_usr_id]," ).append("\n"); 
		query.append("       sysdate" ).append("\n"); 
		query.append("FROM dual" ).append("\n"); 

	}
}