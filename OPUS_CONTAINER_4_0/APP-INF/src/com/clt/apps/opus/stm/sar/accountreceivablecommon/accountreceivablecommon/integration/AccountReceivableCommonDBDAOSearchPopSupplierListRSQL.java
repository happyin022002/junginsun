/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableCommonDBDAOSearchPopSupplierListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableCommonDBDAOSearchPopSupplierListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * STM_SAP_0002- Supplier Pop List
	  * </pre>
	  */
	public AccountReceivableCommonDBDAOSearchPopSupplierListRSQL(){
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
		params.put("vndr_lgl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration").append("\n"); 
		query.append("FileName : AccountReceivableCommonDBDAOSearchPopSupplierListRSQL").append("\n"); 
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
		query.append(" VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append(" ,VNDR_SEQ" ).append("\n"); 
		query.append(" ,INV_CURR_CD" ).append("\n"); 
		query.append(" ,PAY_CURR_CD" ).append("\n"); 
		query.append(" ,GEN_PAY_TERM_CD" ).append("\n"); 
		query.append(" ,VNDR_CNT_CD" ).append("\n"); 
		query.append(" ,RGST_NO" ).append("\n"); 
		query.append(" ,TAX_ID" ).append("\n"); 
		query.append("FROM MDM_VENDOR" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("  AND VNDR_SEQ LIKE @[vndr_seq]||'%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_lgl_eng_nm} != '')" ).append("\n"); 
		query.append("  AND UPPER(VNDR_LGL_ENG_NM) LIKE '%'||UPPER(@[vndr_lgl_eng_nm])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${delt_flg} != '')" ).append("\n"); 
		query.append("  AND NVL(DELT_FLG,'Y') = @[delt_flg]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  AND NVL(DELT_FLG,'Y') = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}