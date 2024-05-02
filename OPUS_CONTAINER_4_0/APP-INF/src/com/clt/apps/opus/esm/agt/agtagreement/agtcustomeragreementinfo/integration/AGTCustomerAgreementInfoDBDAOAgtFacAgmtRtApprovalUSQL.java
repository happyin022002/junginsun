/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTCustomerAgreementInfoDBDAOAgtFacAgmtRtApprovalUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.16
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.16 이호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtagreement.agtcustomeragreementinfo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTCustomerAgreementInfoDBDAOAgtFacAgmtRtApprovalUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AgtFacAgmtRtApproval
	  * </pre>
	  */
	public AGTCustomerAgreementInfoDBDAOAgtFacAgmtRtApprovalUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_proc_rslt_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_apro_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_fwrd_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_apro_usr_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_fwrd_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_rt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtagreement.agtcustomeragreementinfo.integration").append("\n"); 
		query.append("FileName : AGTCustomerAgreementInfoDBDAOAgtFacAgmtRtApprovalUSQL").append("\n"); 
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
		query.append("UPDATE AGT_FAC_AGMT_RT" ).append("\n"); 
		query.append("SET    COMM_PROC_STS_CD = 'AS'," ).append("\n"); 
		query.append("COMM_PROC_RSLT_RSN = @[comm_proc_rslt_rsn]," ).append("\n"); 
		query.append("FAC_APRO_USR_ID = @[fac_apro_usr_id]," ).append("\n"); 
		query.append("FAC_APRO_USR_EML = @[fac_apro_usr_eml]," ).append("\n"); 
		query.append("FAC_APRO_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE  FAC_OFC_CD = @[fac_ofc_cd]" ).append("\n"); 
		query.append("AND    FRT_FWRD_CNT_CD = @[frt_fwrd_cnt_cd]" ).append("\n"); 
		query.append("AND    FRT_FWRD_CUST_SEQ = @[frt_fwrd_cust_seq]" ).append("\n"); 
		query.append("AND    FAC_RT_SEQ = @[fac_rt_seq]" ).append("\n"); 

	}
}