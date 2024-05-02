/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SPCLCmpnAgreementDBDAODeleteSPCLCmpnAgreementUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.10
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.10 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmagreement.spclcmpnagreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM YOUNG-OH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SPCLCmpnAgreementDBDAODeleteSPCLCmpnAgreementUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DeleteSPCLCmpnAgreement
	  * </pre>
	  */
	public SPCLCmpnAgreementDBDAODeleteSPCLCmpnAgreementUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("spcl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spcl_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmagreement.spclcmpnagreement.integration").append("\n"); 
		query.append("FileName : SPCLCmpnAgreementDBDAODeleteSPCLCmpnAgreementUSQL").append("\n"); 
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
		query.append("UPDATE ACM_SPCL_AGMT" ).append("\n"); 
		query.append("   SET  " ).append("\n"); 
		query.append("        DELT_FLG			= 'Y'," ).append("\n"); 
		query.append("        UPD_USR_ID 			= @[usr_id]," ).append("\n"); 
		query.append("        UPD_DT 				= SYSDATE" ).append("\n"); 
		query.append(" WHERE SPCL_OFC_CD = @[spcl_ofc_cd]" ).append("\n"); 
		query.append("   AND CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("   AND CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("   AND SPCL_AGMT_SEQ = @[spcl_agmt_seq]" ).append("\n"); 

	}
}