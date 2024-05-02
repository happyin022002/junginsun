/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TCharterIOBasicRegisterDAOSearchVendorCustomerVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.02
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOBasicRegisterDAOSearchVendorCustomerVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TCharterIOBasicRegisterDAOSearchVendorCustomerVOUSQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_mgmt_ownr_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_mgmt_ownr_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.integration").append("\n"); 
		query.append("FileName : TCharterIOBasicRegisterDAOSearchVendorCustomerVOUSQL").append("\n"); 
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
		query.append("#if (${condflag} == 'VE') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	update mdm_vendor set" ).append("\n"); 
		query.append("		flet_mgmt_ownr_vndr_seq = @[flet_mgmt_ownr_vndr_seq]," ).append("\n"); 
		query.append("		upd_usr_id = @[upd_usr_id]," ).append("\n"); 
		query.append("		upd_dt = sysdate" ).append("\n"); 
		query.append("	where	vndr_seq = @[vndr_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${condflag} == 'CE') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	update mdm_customer set" ).append("\n"); 
		query.append("		flet_mgmt_ownr_cust_seq = @[flet_mgmt_ownr_cust_seq]," ).append("\n"); 
		query.append("		upd_usr_id = @[upd_usr_id]," ).append("\n"); 
		query.append("		upd_dt = sysdate" ).append("\n"); 
		query.append("	where	cust_cnt_cd = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	and		cust_seq = @[cust_seq]" ).append("\n"); 
		query.append("#elseif (${condflag} == 'CE2')" ).append("\n"); 
		query.append("	UPDATE FMS_CONTRACT set" ).append("\n"); 
		query.append("		VNDR_SEQ = @[vndr_seq],	" ).append("\n"); 
		query.append("		upd_usr_id = @[upd_usr_id]," ).append("\n"); 
		query.append("		upd_dt = sysdate" ).append("\n"); 
		query.append("	WHERE CUST_SEQ =@[cust_seq]" ).append("\n"); 
		query.append("	AND CUST_CNT_CD =@[cust_cnt_cd]" ).append("\n"); 
		query.append("#elseif (${condflag} == 'VE2')" ).append("\n"); 
		query.append("	UPDATE FMS_CONTRACT set" ).append("\n"); 
		query.append("		CUST_CNT_CD = @[cust_cnt_cd]," ).append("\n"); 
		query.append("		CUST_SEQ    = @[cust_seq],	" ).append("\n"); 
		query.append("		upd_usr_id  = @[upd_usr_id]," ).append("\n"); 
		query.append("		upd_dt = sysdate" ).append("\n"); 
		query.append("	WHERE VNDR_SEQ  = @[vndr_seq]" ).append("\n"); 
		query.append("     AND flet_ctrt_tp_cd = 'TI'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}