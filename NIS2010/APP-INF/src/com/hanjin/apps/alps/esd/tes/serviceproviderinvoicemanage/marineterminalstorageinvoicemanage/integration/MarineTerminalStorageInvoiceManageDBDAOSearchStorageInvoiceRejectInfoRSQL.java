/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MarineTerminalStorageInvoiceManageDBDAOSearchStorageInvoiceRejectInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 이정혜
*@LastVersion : 1.0
* 2009.10.23 이정혜
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HARRY
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalStorageInvoiceManageDBDAOSearchStorageInvoiceRejectInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchStorageInvoiceRejectInfo
	  * </pre>
	  */
	public MarineTerminalStorageInvoiceManageDBDAOSearchStorageInvoiceRejectInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.integration ").append("\n"); 
		query.append("FileName : MarineTerminalStorageInvoiceManageDBDAOSearchStorageInvoiceRejectInfoRSQL").append("\n"); 
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
		query.append("A.TML_SO_OFC_CTY_CD   ," ).append("\n"); 
		query.append("A.TML_SO_SEQ          ," ).append("\n"); 
		query.append("A.INV_NO              ," ).append("\n"); 
		query.append("A.VNDR_SEQ            ," ).append("\n"); 
		query.append("A.TML_INV_STS_CD      ," ).append("\n"); 
		query.append("A.TML_INV_RJCT_STS_CD ," ).append("\n"); 
		query.append("A.INV_RJCT_RMK        ," ).append("\n"); 
		query.append("A.UPD_USR_ID          ," ).append("\n"); 
		query.append("TO_CHAR(A.UPD_DT,'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("FROM TES_TML_SO_HDR A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND A.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("AND A.TML_INV_TP_CD = 'ST'" ).append("\n"); 
		query.append("AND NVL(A.DELT_FLG,'N') <> 'Y'" ).append("\n"); 

	}
}