/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SPCLCmpnApprovalDBDAOModifySPCLCmpnApprovalListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmapproval.spclcmpnapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SPCLCmpnApprovalDBDAOModifySPCLCmpnApprovalListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Special Compensation Ex.Rate 정보를 수정한다.
	  * </pre>
	  */
	public SPCLCmpnApprovalDBDAOModifySPCLCmpnApprovalListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cmpn_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmapproval.spclcmpnapproval.integration").append("\n"); 
		query.append("FileName : SPCLCmpnApprovalDBDAOModifySPCLCmpnApprovalListUSQL").append("\n"); 
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
		query.append("UPDATE ACM_SPCL_CMPN" ).append("\n"); 
		query.append("   SET" ).append("\n"); 
		query.append("     PAY_XCH_RT = @[pay_xch_rt]" ).append("\n"); 
		query.append("   , PAY_PPD_AMT = ROUND(PPD_AMT * @[pay_xch_rt],3)" ).append("\n"); 
		query.append("   , PAY_CRNT_AMT = ROUND(CRNT_AMT * @[pay_xch_rt],3)" ).append("\n"); 
		query.append("   , PAY_IF_AMT = ROUND(IF_AMT * @[pay_xch_rt],3)" ).append("\n"); 
		query.append("   , UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("   , UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("   AND SPCL_OFC_CD = @[spcl_ofc_cd]" ).append("\n"); 
		query.append("   AND SPCL_CMPN_SEQ = @[spcl_cmpn_seq]" ).append("\n"); 
		query.append("   AND CUST_CNT_CD   = SUBSTR(@[cust_cnt_seq], 0, 2)" ).append("\n"); 
		query.append("   AND CUST_SEQ      = SUBSTR(@[cust_cnt_seq], 3, 6)" ).append("\n"); 
		query.append("   AND SPCL_CMPN_STS_CD = 'CS' " ).append("\n"); 
		query.append("   AND NVL(PAY_CHK_FLG,'N') = 'Y'" ).append("\n"); 

	}
}