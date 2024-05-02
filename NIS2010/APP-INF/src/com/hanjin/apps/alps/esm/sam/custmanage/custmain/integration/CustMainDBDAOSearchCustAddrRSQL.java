/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CustMainDBDAOSearchCustAddrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.06
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.custmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustMainDBDAOSearchCustAddrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer Address Search
	  * </pre>
	  */
	public CustMainDBDAOSearchCustAddrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("addr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sam.custmanage.custmain.integration").append("\n"); 
		query.append("FileName : CustMainDBDAOSearchCustAddrRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("   CUST_CNT_CD||CUST_SEQ CUST_CD" ).append("\n"); 
		query.append(",  CUST_CNT_CD" ).append("\n"); 
		query.append(",  TRIM(TO_CHAR(CUST_SEQ,'000000')) CUST_SEQ " ).append("\n"); 
		query.append(",  ADDR_TP_CD" ).append("\n"); 
		query.append(",  ADDR_SEQ" ).append("\n"); 
		query.append(",  PRMRY_CHK_FLG" ).append("\n"); 
		query.append(",  BZET_NM" ).append("\n"); 
		query.append(",  BZET_ADDR" ).append("\n"); 
		query.append(",  CTY_NM" ).append("\n"); 
		query.append(",  STE_CD" ).append("\n"); 
		query.append(",  ZIP_CD" ).append("\n"); 
		query.append(",  CNTC_EML" ).append("\n"); 
		query.append(",  CNTC_PSON_NM" ).append("\n"); 
		query.append(",  BZET_RMK" ).append("\n"); 
		query.append(",  CRE_USR_ID" ).append("\n"); 
		query.append(",  CRE_DT" ).append("\n"); 
		query.append(",  UPD_USR_ID" ).append("\n"); 
		query.append(",  UPD_DT" ).append("\n"); 
		query.append(",  DELT_FLG" ).append("\n"); 
		query.append(",  LOCL_ADDR1" ).append("\n"); 
		query.append(",  LOCL_ADDR2" ).append("\n"); 
		query.append(",  LOCL_ADDR3" ).append("\n"); 
		query.append(",  LOCL_ADDR4" ).append("\n"); 
		query.append(",  CNT_CD" ).append("\n"); 
		query.append(",  CRE_USR_ID" ).append("\n"); 
		query.append(",  CRE_DT" ).append("\n"); 
		query.append(",  UPD_USR_ID" ).append("\n"); 
		query.append(",  UPD_DT" ).append("\n"); 
		query.append(",  CRM_ROW_ID ADDR_ROW_ID" ).append("\n"); 
		query.append("FROM MDM_CUST_ADDR" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD =@[cust_cnt_cd]" ).append("\n"); 
		query.append("AND CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("AND DECODE(@[addr_tp_cd],'ALL','Y',ADDR_TP_CD) = DECODE(@[addr_tp_cd],'ALL','Y',@[addr_tp_cd])" ).append("\n"); 
		query.append("AND BZET_ADDR||CRE_USR_ID NOT IN ('DFDFDXB024','RM 812, BYUCKSAN DIGITAL VALLEY 5, 60-73, GASAN-DONG, GEUMCHEON-GU,, SEOULDXB024')" ).append("\n"); 
		query.append("ORDER BY PRMRY_CHK_FLG DESC, DELT_FLG, ADDR_TP_CD, ADDR_SEQ" ).append("\n"); 

	}
}