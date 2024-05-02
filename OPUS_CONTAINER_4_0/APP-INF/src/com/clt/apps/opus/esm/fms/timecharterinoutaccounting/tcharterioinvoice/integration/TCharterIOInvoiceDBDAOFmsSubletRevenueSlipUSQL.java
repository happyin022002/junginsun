/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TCharterIOInvoiceDBDAOFmsSubletRevenueSlipUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.01
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDBDAOFmsSubletRevenueSlipUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sublet Revenue Update
	  * </pre>
	  */
	public TCharterIOInvoiceDBDAOFmsSubletRevenueSlipUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_inv_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slp_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_iss_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDBDAOFmsSubletRevenueSlipUSQL").append("\n"); 
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
		query.append("UPDATE FMS_INV_DTL" ).append("\n"); 
		query.append("   SET SLP_TP_CD = @[slp_tp_cd]," ).append("\n"); 
		query.append("   	   SLP_FUNC_CD = @[slp_func_cd]," ).append("\n"); 
		query.append("	   SLP_OFC_CD = @[slp_ofc_cd]," ).append("\n"); 
		query.append("	   SLP_ISS_DT = @[slp_iss_dt]," ).append("\n"); 
		query.append("	   SLP_SER_NO = @[slp_ser_no]," ).append("\n"); 
		query.append("       VSL_CD = SUBSTR(@[vvd_cd],1,4)," ).append("\n"); 
		query.append("       SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)," ).append("\n"); 
		query.append("       SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)," ).append("\n"); 
		query.append("       REV_DIR_CD = SUBSTR(@[vvd_cd],10,1)," ).append("\n"); 
		query.append("	   TO_INV_NO = @[to_inv_no]," ).append("\n"); 
		query.append("	   UPD_DT = SYSDATE," ).append("\n"); 
		query.append("	   UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(" WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("   AND FLET_ISS_TP_CD = @[flet_iss_tp_cd]" ).append("\n"); 
		query.append("   AND INV_SEQ = @[inv_seq]" ).append("\n"); 
		query.append("   AND INV_DTL_SEQ = @[inv_dtl_seq]" ).append("\n"); 

	}
}