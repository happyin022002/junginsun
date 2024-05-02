/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RailBillingVerifyManageDBDAOCheckFullContainerStatusSecondReturnTimeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2010.04.23 박준용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.railbillingverifymanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailBillingVerifyManageDBDAOCheckFullContainerStatusSecondReturnTimeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Export Available Cargo Return Time Verify
	  * </pre>
	  */
	public RailBillingVerifyManageDBDAOCheckFullContainerStatusSecondReturnTimeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkgNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eqNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndrSeq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.railbillingverifymanage.integration").append("\n"); 
		query.append("FileName : RailBillingVerifyManageDBDAOCheckFullContainerStatusSecondReturnTimeRSQL").append("\n"); 
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
		query.append("TRUNC(TRUNC(TO_DATE(" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("MAX(DECODE (CLZ_TP_CD, 'F', TO_CHAR(NVL(MNL_SET_DT, SYS_SET_DT), 'YYYYMMDD'), '')) AS RAIL_RCV_COFF_FM_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_CLZ_TM" ).append("\n"); 
		query.append("WHERE BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND	  CLZ_TP_CD = 'F'" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", 'YYYYMMDD') - TO_DATE(TO_CHAR(C.G_TIME, 'YYYYMMDD'), 'YYYYMMDD'), 0)) RAIL_RCV_COFF_FM_DT_MIN_GLOBAL," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("MAX(DECODE (CLZ_TP_CD, 'F', TO_CHAR(NVL(MNL_SET_DT, SYS_SET_DT), 'YYYY-MM-DD'), '')) AS RAIL_RCV_COFF_FM_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_CLZ_TM" ).append("\n"); 
		query.append("WHERE BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND	  CLZ_TP_CD = 'F'" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(") RAIL_RCV_COFF_FM_DT," ).append("\n"); 
		query.append("C.POL_CD," ).append("\n"); 
		query.append("C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC((SELECT OFC_CD FROM MDM_VENDOR WHERE VNDR_SEQ = @[vndrSeq])) G_TIME," ).append("\n"); 
		query.append("SUBSTR(POL_NOD_CD, 1, 5) POL_CD," ).append("\n"); 
		query.append("SUBSTR(CNTR_TPSZ_CD, 1, 1) CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("SCE_COP_HDR" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkgNo]" ).append("\n"); 
		query.append("AND   CNTR_NO = @[eqNo]" ).append("\n"); 
		query.append(") C" ).append("\n"); 

	}
}