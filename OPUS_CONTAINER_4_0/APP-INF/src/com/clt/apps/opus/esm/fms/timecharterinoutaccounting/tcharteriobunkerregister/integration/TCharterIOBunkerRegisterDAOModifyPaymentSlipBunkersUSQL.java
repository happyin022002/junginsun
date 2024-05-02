/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TCharterIOBunkerRegisterDAOModifyPaymentSlipBunkersUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.01
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOBunkerRegisterDAOModifyPaymentSlipBunkersUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOBunkerRegisterDAOModifyPaymentSlipBunkersUSQL
	  * </pre>
	  */
	public TCharterIOBunkerRegisterDAOModifyPaymentSlipBunkersUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnk_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slp_func_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.integration").append("\n"); 
		query.append("FileName : TCharterIOBunkerRegisterDAOModifyPaymentSlipBunkersUSQL").append("\n"); 
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
		query.append("UPDATE FMS_BUNKER" ).append("\n"); 
		query.append("   SET SLP_TP_CD = '07'," ).append("\n"); 
		query.append("       SLP_FUNC_CD = @[slp_func_cd]," ).append("\n"); 
		query.append("       SLP_OFC_CD = @[slp_ofc_cd]," ).append("\n"); 
		query.append("       SLP_ISS_DT = TO_CHAR(SYSDATE,'YYMM')," ).append("\n"); 
		query.append("       SLP_SER_NO = @[slp_ser_no]," ).append("\n"); 
		query.append("	   APRO_FLG = DECODE(@[auto_flg],'Y','Y','N')," ).append("\n"); 
		query.append("	   UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("	   UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("   AND BNK_SEQ = @[bnk_seq]" ).append("\n"); 

	}
}