/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTCommDBDAOGrsNetCDVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.01
*@LastModifier : 추경원
*@LastVersion : 1.0
* 2010.10.01 추경원
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyung-won Chu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTCommDBDAOGrsNetCDVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_AGT_0012  화면의 GrsNetCD/Net Ocean Revenue 조회
	  * </pre>
	  */
	public AGTCommDBDAOGrsNetCDVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sail_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTCommDBDAOGrsNetCDVORSQL").append("\n"); 
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
		query.append("GRSNET_GUBUN," ).append("\n"); 
		query.append("AC_TP_CD," ).append("\n"); 
		query.append("NVL" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'Y'" ).append("\n"); 
		query.append("FROM MDM_LOCATION                  POL," ).append("\n"); 
		query.append("MDM_LOCATION                  POD," ).append("\n"); 
		query.append("GL_MON_XCH_RT                 GXR," ).append("\n"); 
		query.append("AGT_CHG_DDCT_REF              DDT," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("BKG.BKG_NO," ).append("\n"); 
		query.append("BKG.POL_CD," ).append("\n"); 
		query.append("BKG.POD_CD," ).append("\n"); 
		query.append("@[ac_seq]       AS AC_SEQ,                                          --:AC_SEQ" ).append("\n"); 
		query.append("@[sail_arr_dt]  AS SA_DT                                            --:SA_DT" ).append("\n"); 
		query.append("FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("WHERE BKG.BKG_NO        = @[bkg_no]                                          --:BKG_NO" ).append("\n"); 
		query.append("AND NVL (@[ar_ofc_cd], ' ')                                             --:AR_OFC_CD" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("'AISBA', 'BAHBA', 'BKKBB', 'BOMBA', 'BOMBB', 'CGPBA', 'CMBBB'," ).append("\n"); 
		query.append("'DACBB', 'DXBBA', 'JEDBA', 'JKTBA', 'JKTBB', 'JORBA', 'KHIBA'," ).append("\n"); 
		query.append("'KWIBA', 'MNLBA', 'OMNBA', 'PKGBB', 'PNHBA', 'RGNBA', 'SGNBB'," ).append("\n"); 
		query.append("'SINBB', 'SINWA', 'SYDBA', 'SYDBB', 'THRBA', 'TPEBB', 'DXBBB'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") INP" ).append("\n"); 
		query.append("WHERE DDT.BKG_NO                    = INP.BKG_NO" ).append("\n"); 
		query.append("AND DDT.AC_SEQ                    = INP.AC_SEQ" ).append("\n"); 
		query.append("AND POL.LOC_CD                    = INP.POL_CD" ).append("\n"); 
		query.append("AND POD.LOC_CD                    = INP.POD_CD" ).append("\n"); 
		query.append("AND GXR.CURR_CD                   = DDT.CURR_CD" ).append("\n"); 
		query.append("AND GXR.ACCT_XCH_RT_LVL           = '1'" ).append("\n"); 
		query.append("AND GXR.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("=" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN INP.SA_DT IS NULL" ).append("\n"); 
		query.append("OR 1 = SIGN (TO_DATE (SUBSTR (INP.SA_DT, 1, 6), 'YYYYMM') - SYSDATE)" ).append("\n"); 
		query.append("THEN TO_CHAR (SYSDATE, 'YYYYMM')" ).append("\n"); 
		query.append("ELSE SUBSTR (INP.SA_DT, 1, 6)" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("AND EXISTS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'X'" ).append("\n"); 
		query.append("FROM AGT_CHG_DDCT_REF DD2" ).append("\n"); 
		query.append("WHERE DD2.CHG_CD       = 'BAF'" ).append("\n"); 
		query.append("AND DD2.BKG_NO       = INP.BKG_NO" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'X'" ).append("\n"); 
		query.append("FROM BKG_CHG_RT BR2" ).append("\n"); 
		query.append("WHERE BR2.CHG_CD       = 'BAF'" ).append("\n"); 
		query.append("AND NVL (BR2.FRT_INCL_XCLD_DIV_CD, 'N')" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("'N', 'E'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND BR2.BKG_NO       = INP.BKG_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("---------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("AND DDT.CHG_CD                    = 'FRC'" ).append("\n"); 
		query.append("AND INP.SA_DT                    >= '20100101'" ).append("\n"); 
		query.append("AND" ).append("\n"); 
		query.append("( POL.CONTI_CD" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("'E', 'F'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR POD.CONTI_CD" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("'E', 'F'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("---------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",'N'" ).append("\n"); 
		query.append(") AS FRC_FLG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("GRS_NET_DIV_CD AS GRSNET_GUBUN," ).append("\n"); 
		query.append("AC_TP_CD," ).append("\n"); 
		query.append("AR_OFC_CD," ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("SAIL_ARR_DT" ).append("\n"); 
		query.append("FROM AGT_AGN_COMM" ).append("\n"); 
		query.append("WHERE BKG_NO    = @[bkg_no]" ).append("\n"); 
		query.append("AND AGN_CD    = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND AC_TP_CD" ).append("\n"); 
		query.append("NOT IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("'C', 'D'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append("ORDER BY AC_TP_CD" ).append("\n"); 
		query.append(") X" ).append("\n"); 

	}
}