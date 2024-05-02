/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOInvoiceDAOSearchChaterInvoiceSdmsListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDAOSearchChaterInvoiceSdmsListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOInvoiceDAOSearchChaterInvoiceSdmsListRSQL
	  * </pre>
	  */
	public TCharterIOInvoiceDAOSearchChaterInvoiceSdmsListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_pay_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_pay_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDAOSearchChaterInvoiceSdmsListRSQL").append("\n"); 
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
		query.append("SELECT A.STV_DMG_NO" ).append("\n"); 
		query.append("     , A.VSL_CD" ).append("\n"); 
		query.append("     , A.SKD_VOY_NO || A.SKD_DIR_CD DIRECTION" ).append("\n"); 
		query.append("     , NVL(E.REV_DIR_CD,( SELECT LISTAGG (V.RLANE_DIR_CD, '|') WITHIN GROUP ( ORDER BY V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD)" ).append("\n"); 
		query.append("                            FROM AR_MST_REV_VVD V" ).append("\n"); 
		query.append("                           WHERE V.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("                             AND V.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                             AND V.SKD_DIR_CD = A.SKD_DIR_CD)) AS REV_DIR_CD" ).append("\n"); 
		query.append("     , A.VPS_PORT_CD" ).append("\n"); 
		query.append("     , (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD01882'" ).append("\n"); 
		query.append("           AND INTG_CD_VAL_CTNT = B.STV_DMG_PRT_CATE_CD) STV_DMG_PRT_CATE_CD" ).append("\n"); 
		query.append("     , DECODE(C.STV_DMG_STL_PROC_STS_CD,'P',C.PAY_CURR_CD) PAY_CURR_CD" ).append("\n"); 
		query.append("     , DECODE(C.STV_DMG_STL_PROC_STS_CD,'P',TO_CHAR(C.PAY_LOCL_AMT,'FM999,999,999,999,990.00')) PAY_LOCL_AMT" ).append("\n"); 
		query.append("     , DECODE(C.STV_DMG_STL_PROC_STS_CD,'P',C.BIL_INV_NO) BIL_INV_NO" ).append("\n"); 
		query.append("     , TO_CHAR(A.STV_DMG_EVNT_DT,'YYYYMMDD') PAY_DT" ).append("\n"); 
		query.append("     , DECODE(E.SDMS_NO,NULL,'No','Yes') INV_STATUS" ).append("\n"); 
		query.append("     , DECODE(C.STV_DMG_NO,NULL,B.STV_DMG_LOC_DESC,C.STL_RMK) STV_DMG_RMK" ).append("\n"); 
		query.append("     , 'P' STV_DMG_STL_PROC_STS_CD" ).append("\n"); 
		query.append("     , TO_CHAR(A.STV_DMG_EVNT_DT,'YYYYMMDD') IMSI_PAY_DT" ).append("\n"); 
		query.append("  FROM OPF_STV_DMG A" ).append("\n"); 
		query.append("     , OPF_STV_DMG_DTL B" ).append("\n"); 
		query.append("     , OPF_STV_DMG_STL C" ).append("\n"); 
		query.append("     , FMS_INV_DTL E" ).append("\n"); 
		query.append(" WHERE A.STV_DMG_NO = B.STV_DMG_NO" ).append("\n"); 
		query.append("   AND A.STV_DMG_NO = C.STV_DMG_NO(+)" ).append("\n"); 
		query.append("   AND A.STV_DMG_NO = E.SDMS_NO(+)" ).append("\n"); 
		query.append("   AND A.VSL_CD IN (SELECT VSL_CD" ).append("\n"); 
		query.append("                      FROM FMS_CONTRACT" ).append("\n"); 
		query.append("                     WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("                     UNION ALL" ).append("\n"); 
		query.append("                    SELECT VSL_CD" ).append("\n"); 
		query.append("                      FROM FMS_ID_VSL" ).append("\n"); 
		query.append("                     WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("                       AND USE_FLG = 'Y')" ).append("\n"); 
		query.append("#if(${app_flg} == 'N')" ).append("\n"); 
		query.append("   AND E.SDMS_NO IS NULL" ).append("\n"); 
		query.append("#elseif(${app_flg} == 'Y')" ).append("\n"); 
		query.append("   AND E.SDMS_NO IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${from_pay_dt} != '')" ).append("\n"); 
		query.append("   AND TO_CHAR(A.STV_DMG_EVNT_DT,'YYYYMMDD') BETWEEN REPLACE(@[from_pay_dt],'-','') AND REPLACE(@[to_pay_dt],'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY SUBSTR(A.STV_DMG_NO,4)" ).append("\n"); 

	}
}