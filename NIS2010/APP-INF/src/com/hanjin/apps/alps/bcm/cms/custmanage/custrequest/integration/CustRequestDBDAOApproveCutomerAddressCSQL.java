/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : CustRequestDBDAOApproveCutomerAddressCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.02.19
*@LastModifier : 
*@LastVersion : 1.0
* 2018.02.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.custrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustRequestDBDAOApproveCutomerAddressCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Approve Create Customer address
	  * </pre>
	  */
	public CustRequestDBDAOApproveCutomerAddressCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("addr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.cms.custmanage.custrequest.integration").append("\n"); 
		query.append("FileName : CustRequestDBDAOApproveCutomerAddressCSQL").append("\n"); 
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
		query.append("INSERT INTO MDM_CUST_ADDR(" ).append("\n"); 
		query.append("   CUST_CNT_CD" ).append("\n"); 
		query.append(",  CUST_SEQ " ).append("\n"); 
		query.append(",  ADDR_TP_CD" ).append("\n"); 
		query.append(",  ADDR_SEQ" ).append("\n"); 
		query.append(",  BZET_NM" ).append("\n"); 
		query.append(",  BZET_ADDR" ).append("\n"); 
		query.append(",  CNT_CD" ).append("\n"); 
		query.append(",  CTY_NM" ).append("\n"); 
		query.append(",  STE_CD" ).append("\n"); 
		query.append(",  ZIP_CD" ).append("\n"); 
		query.append(",  PRMRY_CHK_FLG" ).append("\n"); 
		query.append(",  DELT_FLG" ).append("\n"); 
		query.append(",  CRE_USR_ID" ).append("\n"); 
		query.append(",  CRE_DT" ).append("\n"); 
		query.append(",  UPD_USR_ID" ).append("\n"); 
		query.append(",  UPD_DT" ).append("\n"); 
		query.append(",  CRM_ROW_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT    substr(@[cust_cd],1,2)" ).append("\n"); 
		query.append("        , substr(@[cust_cd],3,6)" ).append("\n"); 
		query.append("        , '1'" ).append("\n"); 
		query.append("        , @[addr_seq]" ).append("\n"); 
		query.append("        , ''" ).append("\n"); 
		query.append("        , BZET_ADDR" ).append("\n"); 
		query.append("        , substr(@[cust_cd],1,2)" ).append("\n"); 
		query.append("        , CTY_NM" ).append("\n"); 
		query.append("        , STE_CD" ).append("\n"); 
		query.append("        , ZIP_CD" ).append("\n"); 
		query.append("        , 'Y'" ).append("\n"); 
		query.append("        , 'N'" ).append("\n"); 
		query.append("        , UPD_USR_ID" ).append("\n"); 
		query.append("        , UPD_DT" ).append("\n"); 
		query.append("        , UPD_USR_ID" ).append("\n"); 
		query.append("        , UPD_DT" ).append("\n"); 
		query.append("        , 'ALPS-'||@[addr_seq]" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER_RQST MCR" ).append("\n"); 
		query.append("WHERE MCR.MDM_CUSTOMER_RQST_SEQ = @[rqst_no]" ).append("\n"); 

	}
}