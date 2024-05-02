/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PrdCommonManageDBDAOValidationVendorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.12
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.common.prdcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCommonManageDBDAOValidationVendorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ValidationVendor
	  * </pre>
	  */
	public PrdCommonManageDBDAOValidationVendorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("check_data",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.common.prdcommon.integration").append("\n"); 
		query.append("FileName : PrdCommonManageDBDAOValidationVendorRSQL").append("\n"); 
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
		query.append("SELECT M.VNDR_SEQ vendor_seq, M.VNDR_ABBR_NM com_data1, VNDR_LGL_ENG_NM com_data2" ).append("\n"); 
		query.append("#if (${skip_flag_fun_itemControl} =='Y') " ).append("\n"); 
		query.append("	FROM MDM_VENDOR M --TRS_AGMT_HDR H, TRS_AGMT_APLY_VNDR V, TRS_AGMT_EQ_RT R, " ).append("\n"); 
		query.append("	WHERE 1=1" ).append("\n"); 
		query.append("	AND m.VNDR_SEQ             = @[check_data] " ).append("\n"); 
		query.append("	AND NVL(M.DELT_FLG, 'N')   = 'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	FROM MDM_VENDOR M ,TRS_AGMT_HDR H, TRS_AGMT_APLY_VNDR V, TRS_AGMT_EQ_RT R " ).append("\n"); 
		query.append("	WHERE 1=1" ).append("\n"); 
		query.append("	AND H.TRSP_AGMT_OFC_CTY_CD = V.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("	AND H.TRSP_AGMT_SEQ        = V.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("	AND H.TRSP_AGMT_OFC_CTY_CD = R.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("	AND H.TRSP_AGMT_SEQ        = R.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("	AND NVL(V.DELT_FLG, 'N')   = 'N'" ).append("\n"); 
		query.append("	AND V.VNDR_SEQ             = M.VNDR_SEQ" ).append("\n"); 
		query.append("	AND m.VNDR_SEQ             = @[check_data] " ).append("\n"); 
		query.append("	AND NVL(M.DELT_FLG, 'N')   = 'N'" ).append("\n"); 
		query.append("	AND SYSDATE BETWEEN R.EFF_FM_DT AND R.EFF_TO_DT " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND ROWNUM                 = 1" ).append("\n"); 

	}
}