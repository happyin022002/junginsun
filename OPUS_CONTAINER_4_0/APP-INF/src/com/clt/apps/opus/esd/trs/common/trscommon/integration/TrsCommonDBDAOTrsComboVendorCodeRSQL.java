/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TrsCommonDBDAOTrsComboVendorCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.common.trscommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsCommonDBDAOTrsComboVendorCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Select
	  * </pre>
	  */
	public TrsCommonDBDAOTrsComboVendorCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vendor_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.common.trscommon.integration").append("\n"); 
		query.append("FileName : TrsCommonDBDAOTrsComboVendorCodeRSQL").append("\n"); 
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
		query.append("SELECT   V.VNDR_CNT_CD     AS INTG_CD_ID" ).append("\n"); 
		query.append(",        V.VNDR_SEQ        AS INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append(",        V.VNDR_ABBR_NM    AS INTG_CD_VAL_DESC" ).append("\n"); 
		query.append(",        V.VNDR_LGL_ENG_NM AS INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append(",        ROWNUM            AS INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("FROM     MDM_VENDOR V" ).append("\n"); 
		query.append(",        MDM_CNTR_VNDR_CLSS C" ).append("\n"); 
		query.append("WHERE    V.VNDR_SEQ = @[vendor_code]" ).append("\n"); 
		query.append("AND      V.VNDR_SEQ = C.VNDR_SEQ" ).append("\n"); 
		query.append("AND      V.VNDR_CNT_CD IN ('CA', 'US')" ).append("\n"); 
		query.append("AND      C.CNTR_VNDR_SVC_CD = 'RAIL'" ).append("\n"); 
		query.append("AND      NVL(C.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 

	}
}