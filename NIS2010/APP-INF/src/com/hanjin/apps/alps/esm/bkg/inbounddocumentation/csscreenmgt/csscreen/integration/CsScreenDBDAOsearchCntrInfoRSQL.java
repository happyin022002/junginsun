/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CsScreenDBDAOsearchCntrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CsScreenDBDAOsearchCntrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG에 해당하는 컨테이너 정보를 조회한다.
	  * </pre>
	  */
	public CsScreenDBDAOsearchCntrInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("bb_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration").append("\n"); 
		query.append("FileName : CsScreenDBDAOsearchCntrInfoRSQL").append("\n"); 
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
		query.append("SELECT A.BKG_NO," ).append("\n"); 
		query.append("          A.CNTR_NO," ).append("\n"); 
		query.append("          A.CNMV_STS_CD," ).append("\n"); 
		query.append("          A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("          ltrim(to_char(A.PCK_QTY,'999,999')) PCK_QTY," ).append("\n"); 
		query.append("          A.PCK_TP_CD," ).append("\n"); 
		query.append("          ltrim(to_char(A.CNTR_WGT,'99,999,999.99')) CNTR_WGT," ).append("\n"); 
		query.append("          A.WGT_UT_CD," ).append("\n"); 
		query.append("          ltrim(to_char(A.MEAS_QTY,'999,999')) MEAS_QTY," ).append("\n"); 
		query.append("          A.MEAS_UT_CD," ).append("\n"); 
		query.append("          A.RCV_TERM_CD," ).append("\n"); 
		query.append("          A.DE_TERM_CD," ).append("\n"); 
		query.append("          A.ADV_SHTG_CD," ).append("\n"); 
		query.append("          A.CNMV_STS_CD," ).append("\n"); 
		query.append("          A.DCGO_FLG," ).append("\n"); 
		query.append("          @[bb_cgo_flg] BB_CGO_FLG," ).append("\n"); 
		query.append("          A.AWK_CGO_FLG," ).append("\n"); 
		query.append("          A.RC_FLG," ).append("\n"); 
		query.append("          A.RD_CGO_FLG," ).append("\n"); 
		query.append("          A.SOC_FLG," ).append("\n"); 
		query.append("          CASE WHEN B.BKG_NO IS NULL THEN 'N' " ).append("\n"); 
		query.append("               ELSE CASE WHEN (OVR_FWRD_LEN + OVR_BKWD_LEN +OVR_HGT + OVR_LF_LEN + OVR_RT_LEN) > 0  THEN 'OUT' -- arr_ntc 이 있을경우 pass" ).append("\n"); 
		query.append("                         ELSE 'IN' END END IN_GA_FLG, " ).append("\n"); 
		query.append("          NVL(TO_CHAR(C.CDO_TEMP), 'N')         CDO_TEMP,          " ).append("\n"); 
		query.append("          @[bkg_cgo_tp_cd] AS FM_STS_CD" ).append("\n"); 
		query.append("     FROM BKG_CONTAINER    A," ).append("\n"); 
		query.append("          BKG_AWK_CGO      B," ).append("\n"); 
		query.append("          BKG_RF_CGO       C" ).append("\n"); 
		query.append("    WHERE A.BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("      AND A.CNTR_DELT_FLG = 'N'" ).append("\n"); 
		query.append("      AND A.BKG_NO        = B.BKG_NO (+)" ).append("\n"); 
		query.append("      AND A.CNTR_NO       = B.CNTR_NO(+)" ).append("\n"); 
		query.append("      AND A.BKG_NO        = C.BKG_NO (+)" ).append("\n"); 
		query.append("      AND A.CNTR_NO       = C.CNTR_NO(+)" ).append("\n"); 

	}
}