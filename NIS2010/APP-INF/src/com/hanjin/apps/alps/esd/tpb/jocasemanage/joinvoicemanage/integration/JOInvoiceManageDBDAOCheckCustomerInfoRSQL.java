/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JOInvoiceManageDBDAOCheckCustomerInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2010.02.22 변종건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Geon Byeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOInvoiceManageDBDAOCheckCustomerInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckCustomerInfo
	  * </pre>
	  */
	public JOInvoiceManageDBDAOCheckCustomerInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_his_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.integration").append("\n"); 
		query.append("FileName : JOInvoiceManageDBDAOCheckCustomerInfoRSQL").append("\n"); 
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
		query.append("DECODE( HDR.VNDR_CUST_DIV_CD," ).append("\n"); 
		query.append("'C', NVL2(HDR.CUST_CNT_CD," ).append("\n"); 
		query.append("NVL2(HDR.CUST_SEQ,1,0)" ).append("\n"); 
		query.append(", 0" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("'V', NVL2(HDR.VNDR_SEQ," ).append("\n"); 
		query.append("( SELECT COUNT(0) CNT" ).append("\n"); 
		query.append("FROM MDM_VENDOR V" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND V.VNDR_SEQ = HDR.VNDR_SEQ" ).append("\n"); 
		query.append("AND V.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND V.RFND_PSDO_CUST_CD IS NOT NULL" ).append("\n"); 
		query.append("AND ROWNUM = 1 )" ).append("\n"); 
		query.append(", 0" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("0" ).append("\n"); 
		query.append(") CNT" ).append("\n"); 
		query.append("FROM TPB_INV_RVIS HDR, TPB_INVOICE INV" ).append("\n"); 
		query.append("WHERE HDR.N3PTY_INV_NO = INV.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND HDR.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("AND HDR.N3PTY_INV_NO = @[s_n3pty_inv_no]" ).append("\n"); 
		query.append("AND HDR.N3PTY_INV_RVIS_SEQ = @[s_n3pty_inv_his_seq]" ).append("\n"); 

	}
}