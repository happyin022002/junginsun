/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvoiceAuditDBDAOSearchApPayInvDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.07
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2011.06.07 최종혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceAuditDBDAOSearchApPayInvDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AP_PAY_INV_DTL 테이블 INSERT
	  * </pre>
	  */
	public InvoiceAuditDBDAOSearchApPayInvDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration").append("\n"); 
		query.append("FileName : InvoiceAuditDBDAOSearchApPayInvDetailRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("NVL(LGS_COST_CD,'000000') AS LGS_COST_CD" ).append("\n"); 
		query.append(",NVL(ACCT_CD,'000000') AS ACCT_CD" ).append("\n"); 
		query.append(",NVL(VSL_CD,'0000') VSL_CD" ).append("\n"); 
		query.append(",NVL(SKD_VOY_NO,'0000') SKD_VOY_NO" ).append("\n"); 
		query.append(",NVL(SKD_DIR_CD,'0') SKD_DIR_CD" ).append("\n"); 
		query.append(",NVL(SKD_DIR_CD,'0') REV_DIR_CD" ).append("\n"); 
		query.append(",SLAN_CD" ).append("\n"); 
		query.append(",NVL(VSL_CD,'0000')||NVL(SKD_VOY_NO,'0000')||NVL(SKD_DIR_CD,'0') AS ACT_VVD_CD" ).append("\n"); 
		query.append(",EQ_TPSZ_CD AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",BZC_AMT + NVL(NEGO_AMT, 0) AS INV_AMT" ).append("\n"); 
		query.append(",TRSP_SO_OFC_CTY_CD AS SO_OFC_CTY_CD" ).append("\n"); 
		query.append(",TRSP_SO_SEQ AS SO_SEQ" ).append("\n"); 
		query.append(",'I' IBFLAG" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD S" ).append("\n"); 
		query.append("WHERE INV_NO = @[inv_no] -- 파라메터로 받음 (Confirm 한 invoice no)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("NVL(LGS_CST.LGS_COST_CD,'000000') AS LGS_COST_CD" ).append("\n"); 
		query.append(",NVL(LGS_CST.ACCT_CD,'000000') AS ACCT_CD" ).append("\n"); 
		query.append(",NVL(SVC_ORD.VSL_CD,'0000') VSL_CD" ).append("\n"); 
		query.append(",NVL(SVC_ORD.SKD_VOY_NO,'0000') SKD_VOY_NO" ).append("\n"); 
		query.append(",NVL(SVC_ORD.SKD_DIR_CD,'0') SKD_DIR_CD" ).append("\n"); 
		query.append(",NVL(SVC_ORD.SKD_DIR_CD,'0') REV_DIR_CD" ).append("\n"); 
		query.append(",SVC_ORD.SLAN_CD" ).append("\n"); 
		query.append(",NVL(SVC_ORD.VSL_CD,'0000')||NVL(SVC_ORD.SKD_VOY_NO,'0000')||NVL(SVC_ORD.SKD_DIR_CD,'0') AS ACT_VVD_CD" ).append("\n"); 
		query.append(",SVC_ORD.EQ_TPSZ_CD AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",SCG_DTL.SCG_AMT + NVL(SCG_DTL.INV_SCG_AMT, 0) AS INV_AMT" ).append("\n"); 
		query.append(",SVC_ORD.TRSP_SO_OFC_CTY_CD AS SO_OFC_CTY_CD" ).append("\n"); 
		query.append(",SVC_ORD.TRSP_SO_SEQ AS SO_SEQ" ).append("\n"); 
		query.append(",'I' IBFLAG" ).append("\n"); 
		query.append("FROM		TRS_TRSP_SVC_ORD 				SVC_ORD" ).append("\n"); 
		query.append(",	TES_LGS_COST					LGS_CST" ).append("\n"); 
		query.append(",	TRS_TRSP_SCG_DTL				SCG_DTL" ).append("\n"); 
		query.append("WHERE		SCG_DTL.TRSP_SO_OFC_CTY_CD 		= SVC_ORD.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND			SCG_DTL.TRSP_SO_SEQ        		= SVC_ORD.TRSP_SO_SEQ" ).append("\n"); 
		query.append("AND			SCG_DTL.LGS_COST_CD        		= LGS_CST.LGS_COST_CD" ).append("\n"); 
		query.append("AND    SVC_ORD.INV_NO = @[inv_no] -- 파라메터로 받음 (Confirm 한 invoice no)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}