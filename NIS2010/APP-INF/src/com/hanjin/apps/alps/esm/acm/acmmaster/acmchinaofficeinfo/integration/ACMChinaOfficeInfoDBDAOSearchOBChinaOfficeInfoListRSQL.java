/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMChinaOfficeInfoDBDAOSearchOBChinaOfficeInfoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.04
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.05.04 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmmaster.acmchinaofficeinfo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMChinaOfficeInfoDBDAOSearchOBChinaOfficeInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ACMChinaOfficeInfoDBDAOSearchOBChinaOfficeInfoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("finc_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmmaster.acmchinaofficeinfo.integration").append("\n"); 
		query.append("FileName : ACMChinaOfficeInfoDBDAOSearchOBChinaOfficeInfoListRSQL").append("\n"); 
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
		query.append("SELECT BCA.CHN_AGN_CD," ).append("\n"); 
		query.append("       BCA.AGN_NM," ).append("\n"); 
		query.append("       LTRIM(TO_CHAR(BCA.VNDR_SEQ, '000000')) AS VNDR_SEQ," ).append("\n"); 
		query.append("       MV.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("       BCA.FINC_OFC_CD," ).append("\n"); 
		query.append("       NVL(BCA.DELT_FLG, 'N') AS DELT_FLG," ).append("\n"); 
		query.append("       NVL(MV.DELT_FLG, 'N') AS VNDR_DELT_FLG," ).append("\n"); 
		query.append("       -- 아래는 BKG UPDATE메서드에 전달하기 위해 필요한 Hidden value" ).append("\n"); 
		query.append("       BCA.BKG_BLCK_FLG," ).append("\n"); 
		query.append("       MV.VNDR_CNT_CD," ).append("\n"); 
		query.append("       MV.OFC_CD," ).append("\n"); 
		query.append("       BCA.DIFF_RMK," ).append("\n"); 
		query.append("       BCA.CUST_CNT_CD," ).append("\n"); 
		query.append("       BCA.CUST_SEQ," ).append("\n"); 
		query.append("       BCA.AUTO_DP_CHK_FLG," ).append("\n"); 
		query.append("       BCA.AGN_EML," ).append("\n"); 
		query.append("       BCA.AR_OFC_CD," ).append("\n"); 
		query.append("       BCA.DIR_PAY_OFC_CD" ).append("\n"); 
		query.append("  FROM BKG_CHN_AGN BCA," ).append("\n"); 
		query.append("       MDM_VENDOR MV" ).append("\n"); 
		query.append(" WHERE BCA.VNDR_SEQ = MV.VNDR_SEQ(+)" ).append("\n"); 
		query.append("#if (${finc_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND BCA.FINC_OFC_CD = @[finc_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${delt_flg} != 'Y')" ).append("\n"); 
		query.append("   AND NVL(BCA.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY SUBSTR(BCA.FINC_OFC_CD, 1, 3)||BCA.CHN_AGN_CD" ).append("\n"); 

	}
}