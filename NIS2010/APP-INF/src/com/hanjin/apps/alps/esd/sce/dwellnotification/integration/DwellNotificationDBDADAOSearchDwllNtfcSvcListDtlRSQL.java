/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DwellNotificationDBDADAOSearchDwllNtfcSvcListDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.22
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DwellNotificationDBDADAOSearchDwllNtfcSvcListDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Email이 중복으로 등록되어 있는지를 체크한다.
	  * </pre>
	  */
	public DwellNotificationDBDADAOSearchDwllNtfcSvcListDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntfc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subsc_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.dwellnotification.integration").append("\n"); 
		query.append("FileName : DwellNotificationDBDADAOSearchDwllNtfcSvcListDtlRSQL").append("\n"); 
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
		query.append("  SELECT DWLL_CUST_CNT_CD || LPAD(DWLL_CUST_SEQ,6,0) CUST_CD, NTFC_SEQ, DELT_FLG" ).append("\n"); 
		query.append("      , CASE WHEN @[ntfc_seq] IS NULL THEN 'ERR1' -- 이미 있는 EMAIL을 재등록 하려고 함" ).append("\n"); 
		query.append("            WHEN @[ntfc_seq] <> NTFC_SEQ THEN 'ERR2' -- 현 EMAIL을 다른 존재하는 EMAIL로 변경하려고 함" ).append("\n"); 
		query.append("            WHEN COUNT(1) OVER() > 1 THEN 'ERR3' -- 기존에 이미 2건이상 등록되어있음" ).append("\n"); 
		query.append("            ELSE 'Y' END ERR_CHK" ).append("\n"); 
		query.append("FROM SCE_DWLL_CUST_SVC_LIST" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND DWLL_CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("  AND DWLL_CUST_SEQ = TO_NUMBER(SUBSTR(@[cust_cd],3,6))" ).append("\n"); 
		query.append("  AND SUBSC_EML = TRIM(@[subsc_eml])" ).append("\n"); 

	}
}