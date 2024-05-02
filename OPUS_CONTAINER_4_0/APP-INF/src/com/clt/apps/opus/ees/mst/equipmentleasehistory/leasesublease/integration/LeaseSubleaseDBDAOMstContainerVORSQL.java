/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : LeaseSubleaseDBDAOMstContainerVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.08
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.11.08 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LeaseSubleaseDBDAOMstContainerVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Status Inquiry
	  * </pre>
	  */
	public LeaseSubleaseDBDAOMstContainerVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.integration").append("\n"); 
		query.append("FileName : LeaseSubleaseDBDAOMstContainerVORSQL").append("\n"); 
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
		query.append("       A.CNTR_NO,   " ).append("\n"); 
		query.append("       SUBSTR(A.CNTR_NO,11) CHK_DGT, " ).append("\n"); 
		query.append("       DECODE(A.ACIAC_DIV_CD, 'I', 'Inactive','A','Active') ACIAC_DIV_CD, " ).append("\n"); 
		query.append("       A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       A.LSTM_CD, " ).append("\n"); 
		query.append("       B.CNTR_TPSZ_ISO_CD, " ).append("\n"); 
		query.append("       DECODE(C.CNTR_OLD_VAN_FLG,'Y', 'Old', 'New') CNTR_OLD_VAN_FLG," ).append("\n"); 
		query.append("       NVL(( SELECT COM_CONSTANTMGR_PKG.COM_getCompanyName_FNC()" ).append("\n"); 
		query.append("             FROM MNR_TTL_LSS_RQST_HDR TH" ).append("\n"); 
		query.append("                , MNR_TTL_LSS_RQST_DTL TD" ).append("\n"); 
		query.append("            WHERE 1                   = 1" ).append("\n"); 
		query.append("              AND    TH.TTL_LSS_STS_CD = 'HA'" ).append("\n"); 
		query.append("              AND    TH.TTL_LSS_NO      = TD.TTL_LSS_NO" ).append("\n"); 
		query.append("              AND    TD.RQST_EQ_NO    = A.CNTR_NO" ).append("\n"); 
		query.append("              AND    A.ONH_DT < TH.TTL_LSS_DT" ).append("\n"); 
		query.append("              AND    ROWNUM            = 1), DECODE(A.CNTR_STS_CD||A.CNMV_STS_CD||A.ACIAC_DIV_CD, 'OWNMTInactive', 'Not Receiving', MV.VNDR_LGL_ENG_NM) " ).append("\n"); 
		query.append("        ) AS OWNR_CO_CD," ).append("\n"); 
		query.append("       COM_CONSTANTMGR_PKG.COM_getCompanyName_FNC() AS CNTR_USE_CO_CD" ).append("\n"); 
		query.append("FROM MST_CONTAINER A, " ).append("\n"); 
		query.append("     MDM_CNTR_TP_SZ B," ).append("\n"); 
		query.append("     MST_CNTR_STS_HIS C," ).append("\n"); 
		query.append("     MDM_VENDOR MV" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND	A.CNTR_NO = MST_COMMON_PKG.MST_CNTR_NO_FNC(@[cntr_no])" ).append("\n"); 
		query.append("AND B.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND C.CNTR_NO(+)   = A.CNTR_NO" ).append("\n"); 
		query.append("AND A.VNDR_SEQ     = MV.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}