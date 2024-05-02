/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchKorDoAttorneyListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchKorDoAttorneyListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cargo Release시 한국 지역에 한하여 위임자 및 수임자 정보를 조회한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchKorDoAttorneyListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_name",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_biz_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchKorDoAttorneyListRSQL").append("\n"); 
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
		query.append("SELECT A.FM_ATTY_BIZ_NO" ).append("\n"); 
		query.append(", B.ATTY_CUST_NM AS FM_ATTY_BIZ_NM" ).append("\n"); 
		query.append(", A.TO_ATTY_BIZ_NO" ).append("\n"); 
		query.append(", C.ATTY_CUST_NM AS TO_ATTY_BIZ_NM" ).append("\n"); 
		query.append(", TO_CHAR(A.EFF_DT, 'YYYYMMDD') AS EFF_DT" ).append("\n"); 
		query.append(", TO_CHAR(A.EXP_DT, 'YYYYMMDD') AS EXP_DT" ).append("\n"); 
		query.append(", A.ACCT_FLG" ).append("\n"); 
		query.append(", A.DIFF_RMK" ).append("\n"); 
		query.append(", A.RGST_OFC_CD" ).append("\n"); 
		query.append(", A.RGST_DT" ).append("\n"); 
		query.append(", A.RGST_USR_ID" ).append("\n"); 
		query.append(", A.UPD_OFC_CD" ).append("\n"); 
		query.append(", A.CRE_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(A.CRE_DT, 'YYYYMMDD') AS CRE_DT" ).append("\n"); 
		query.append(", A.UPD_USR_ID" ).append("\n"); 
		query.append(", (SELECT USR_NM FROM COM_USER WHERE USR_ID = A.UPD_USR_ID) AS UPD_USR_NM" ).append("\n"); 
		query.append(", TO_CHAR(A.UPD_DT, 'YYYYMMDD') AS UPD_DT" ).append("\n"); 
		query.append(", '0' AS DUP_CNT" ).append("\n"); 
		query.append(", TO_CHAR(SYSDATE, 'YYYYMMDD') AS CURRENT_DT" ).append("\n"); 
		query.append("FROM BKG_DO_ATTY_DTL A" ).append("\n"); 
		query.append(", BKG_DO_ATTY B" ).append("\n"); 
		query.append(", BKG_DO_ATTY C" ).append("\n"); 
		query.append("WHERE A.FM_ATTY_BIZ_NO = B.ATTY_BIZ_NO" ).append("\n"); 
		query.append("AND A.TO_ATTY_BIZ_NO = C.ATTY_BIZ_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_type} == 'to' && ${cust_biz_no} != '')" ).append("\n"); 
		query.append("AND B.ATTY_BIZ_NO = @[cust_biz_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_type} == 'to' && ${cust_biz_no} == '' && ${cust_name} != '')" ).append("\n"); 
		query.append("AND LOWER(B.ATTY_CUST_NM) LIKE LOWER(trim(@[cust_name]))||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_type} == 'fm' && ${cust_biz_no} != '')" ).append("\n"); 
		query.append("AND C.ATTY_BIZ_NO = @[cust_biz_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_type} == 'fm' && ${cust_biz_no} == '' && ${cust_name} != '')" ).append("\n"); 
		query.append("AND LOWER(C.ATTY_CUST_NM) LIKE LOWER(trim(@[cust_name]))||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY 2,4" ).append("\n"); 

	}
}