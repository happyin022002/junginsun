/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingARCreationDBDAOSearchInvSubAgnCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.04
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.03.04 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOSearchInvSubAgnCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BookingARCreationDBDAOSearchInvSubAgnCustomerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOSearchInvSubAgnCustomerRSQL").append("\n"); 
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
		query.append("SELECT REP_CUST_CNT_CD ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("      ,REP_CUST_SEQ    ACT_CUST_SEQ" ).append("\n"); 
		query.append("  FROM INV_SUB_AGN_CUST_CD A," ).append("\n"); 
		query.append("       MDM_CUSTOMER        B" ).append("\n"); 
		query.append(" WHERE A.REP_CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("   AND A.REP_CUST_SEQ = B.CUST_SEQ" ).append("\n"); 
		query.append("   AND A.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("   AND A.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("   AND DECODE(A.POR_CD,'XXXXX', @[por_cd], A.POR_CD) = @[por_cd]" ).append("\n"); 
		query.append("   AND DECODE(A.POL_CD,'XXXXX', @[pol_cd], A.POL_CD) = @[pol_cd]" ).append("\n"); 
		query.append("   AND DECODE(A.POD_CD,'XXXXX', @[pod_cd], A.POD_CD) = @[pod_cd]" ).append("\n"); 
		query.append("   AND DECODE(A.DEL_CD,'XXXXX', @[del_cd], A.DEL_CD) = @[del_cd]" ).append("\n"); 
		query.append("   AND NVL(A.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("   AND NVL(B.DELT_FLG,'N') <> 'Y'" ).append("\n"); 

	}
}