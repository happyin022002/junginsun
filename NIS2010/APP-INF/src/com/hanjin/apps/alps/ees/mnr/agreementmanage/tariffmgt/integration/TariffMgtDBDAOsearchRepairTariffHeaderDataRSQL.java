/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffMgtDBDAOsearchRepairTariffHeaderDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.04
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2010.04.04 이주현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffMgtDBDAOsearchRepairTariffHeaderDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public TariffMgtDBDAOsearchRepairTariffHeaderDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.integration").append("\n"); 
		query.append("FileName : TariffMgtDBDAOsearchRepairTariffHeaderDataRSQL").append("\n"); 
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
		query.append("SELECT   A.TRF_NO" ).append("\n"); 
		query.append(",A.EQ_KND_CD" ).append("\n"); 
		query.append(",A.MNR_TRF_KND_CD" ).append("\n"); 
		query.append(",A.MNR_INP_TP_CD" ).append("\n"); 
		query.append("--,A.VNDR_SEQ" ).append("\n"); 
		query.append(",MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(A.VNDR_SEQ) AS VNDR_SEQ" ).append("\n"); 
		query.append(",A.APRO_OFC_CD" ).append("\n"); 
		query.append(",A.MNR_TRF_STS_CD" ).append("\n"); 
		query.append(",TO_CHAR(A.MNR_TRF_STS_DT, 'yyyy-mm-dd') MNR_TRF_STS_DT" ).append("\n"); 
		query.append(",A.STS_REF_NO" ).append("\n"); 
		query.append(",A.MNR_MEAS_UT_CD" ).append("\n"); 
		query.append(",A.CURR_CD" ).append("\n"); 
		query.append(",TO_CHAR(A.EFF_DT, 'yyyy-mm-dd') EFF_DT" ).append("\n"); 
		query.append(",A.MNR_TRF_RMK" ).append("\n"); 
		query.append(",A.RQST_OFC_CD" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), A.CRE_DT, @[ofc_cd]), 'yyyy-mm-dd') CRE_DT" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(A.UPD_DT, 'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append("FROM MNR_RPR_TRF_HDR A" ).append("\n"); 
		query.append("WHERE A.TRF_NO = @[search_trf_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${access_system} == 'ALP')" ).append("\n"); 
		query.append("AND A.MNR_TRF_STS_CD NOT IN ('SD','HD','SS')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.MNR_TRF_STS_CD NOT IN ('SD','HD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}