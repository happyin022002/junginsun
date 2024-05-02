/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOsearchOfficeVendorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOsearchOfficeVendorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchOfficeVendor
	  * -------------------------------------------------------------------------
	  * 2010.11.24 이석준 CHM-201007129-01 Service provider help pop-up내 Delete 칼럼 추가
	  * 2014.09.04 속도개선위해 삭제VNDR 조회하지 않음
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOsearchOfficeVendorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOsearchOfficeVendorRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT COUNT(DISTINCT B.VNDR_SEQ) OVER() TCNT" ).append("\n"); 
		query.append("      ,B.VNDR_SEQ" ).append("\n"); 
		query.append("      ,B.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("      ,B.DELT_FLG" ).append("\n"); 
		query.append("      ,B.CNL_AGN_FLG" ).append("\n"); 
		query.append("FROM   PSO_INV_OFC_VNDR A" ).append("\n"); 
		query.append("      ,MDM_VENDOR       B" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    A.VNDR_SEQ(+) = B.VNDR_SEQ" ).append("\n"); 
		query.append("AND    B.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ofc_cd} != '') " ).append("\n"); 
		query.append("AND    A.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vndr_cnt_cd} != '')" ).append("\n"); 
		query.append("AND    B.VNDR_CNT_CD = @[vndr_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vndr_lgl_eng_nm} != '')" ).append("\n"); 
		query.append("AND    UPPER(B.VNDR_LGL_ENG_NM) LIKE '%' || UPPER(@[vndr_lgl_eng_nm]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}