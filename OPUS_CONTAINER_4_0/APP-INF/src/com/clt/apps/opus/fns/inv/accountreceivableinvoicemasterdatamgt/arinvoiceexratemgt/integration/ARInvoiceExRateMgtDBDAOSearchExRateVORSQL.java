/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ARInvoiceExRateMgtDBDAOSearchExRateVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.06
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceExRateMgtDBDAOSearchExRateVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ARInvoiceExRateMgtDBDAOSearchExRateVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xch_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceExRateMgtDBDAOSearchExRateVORSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("     A.CUST_CNT_CD CUST_CNT_CD" ).append("\n"); 
		query.append("    ,A.CUST_SEQ CUST_SEQ" ).append("\n"); 
		query.append("    ,DECODE(A.IO_BND_CD,'I','I/B','O','O/B') IO_BND_CD" ).append("\n"); 
		query.append("    ,A.FM_DT FM_DT" ).append("\n"); 
		query.append("    ,A.TO_DT TO_DT" ).append("\n"); 
		query.append("    ,B.CURR_NM CURR_NM" ).append("\n"); 
		query.append("    ,A.CHG_CURR_CD CHG_CURR_CD" ).append("\n"); 
		query.append("    ,A.LOCL_CURR_CD LOCL_CURR_CD" ).append("\n"); 
		query.append("    ,A.XCH_RT_TP_CD XCH_RT_TP_CD" ).append("\n"); 
		query.append("    ,A.AR_OFC_CD AR_OFC_CD" ).append("\n"); 
		query.append("    ,DECODE(D.XCH_RT_RVS_FLG,'Y',A.IVS_XCH_RT,A.INV_XCH_RT) INV_XCH_RT" ).append("\n"); 
		query.append("    ,DECODE(D.XCH_RT_RVS_FLG,'Y',A.INV_XCH_RT,A.IVS_XCH_RT) IVS_XCH_RT" ).append("\n"); 
		query.append("    ,A.CRE_USR_ID CRE_USR_ID" ).append("\n"); 
		query.append("    ,A.CRE_DT    CRE_DT" ).append("\n"); 
		query.append("    ,A.UPD_USR_ID UPD_USR_ID" ).append("\n"); 
		query.append("    ,A.UPD_DT UPD_DT" ).append("\n"); 
		query.append("    ,MAX(HIS.CNG_RMK) KEEP(DENSE_RANK FIRST ORDER BY HIS.HIS_SEQ DESC) AS CNG_RMK" ).append("\n"); 
		query.append("    ,COUNT(DISTINCT CRT.VSL_CD) VVD_CNT " ).append("\n"); 
		query.append("FROM INV_CUST_AND_DLY_XCH_RT A" ).append("\n"); 
		query.append("   , MDM_CURRENCY B" ).append("\n"); 
		query.append("   , MDM_ORGANIZATION C " ).append("\n"); 
		query.append("   , INV_AR_STUP_OFC D" ).append("\n"); 
		query.append("   , INV_DLY_XCH_RT_HIS HIS" ).append("\n"); 
		query.append("   , INV_VVD_XCH_RT CRT" ).append("\n"); 
		query.append("WHERE A.CHG_CURR_CD = B.CURR_CD" ).append("\n"); 
		query.append("AND   A.AR_OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("AND   A.AR_OFC_CD = D.AR_OFC_CD" ).append("\n"); 
		query.append("#if (${io_bnd_cd} != '')" ).append("\n"); 
		query.append("and	  A.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   A.FM_DT <= REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("AND   A.FM_DT >= REPLACE(@[fm_dt],'-','')" ).append("\n"); 
		query.append("AND	  A.LOCL_CURR_CD = @[locl_curr_cd]" ).append("\n"); 
		query.append("AND   A.CUST_CNT_CD ='XX'" ).append("\n"); 
		query.append("AND   A.CUST_SEQ = 0" ).append("\n"); 
		query.append("AND   A.AR_OFC_CD = D.AR_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND   A.AR_OFC_CD       = HIS.AR_OFC_CD(+)" ).append("\n"); 
		query.append("AND   A.FM_DT           = HIS.FM_DT(+)" ).append("\n"); 
		query.append("AND   A.TO_DT           = HIS.TO_DT(+)" ).append("\n"); 
		query.append("AND   A.IO_BND_CD       = HIS.IO_BND_CD(+)" ).append("\n"); 
		query.append("AND   A.LOCL_CURR_CD    = HIS.LOCL_CURR_CD(+)" ).append("\n"); 
		query.append("AND   A.CHG_CURR_CD     = HIS.CHG_CURR_CD(+)" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("AND   A.FM_DT 			= CRT.XCH_RT_DT(+)" ).append("\n"); 
		query.append("AND   A.IO_BND_CD 		= CRT.IO_BND_CD(+)     " ).append("\n"); 
		query.append("AND   A.LOCL_CURR_CD 	= CRT.LOCL_CURR_CD(+)  " ).append("\n"); 
		query.append("AND   A.CHG_CURR_CD 	= CRT.CHG_CURR_CD (+)  " ).append("\n"); 
		query.append("AND   A.AR_OFC_CD 		= CRT.AR_OFC_CD(+)     " ).append("\n"); 
		query.append("#if (${multi_office_list} != '')" ).append("\n"); 
		query.append("AND   A.AR_OFC_CD IN ( ${multi_office_list} )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND   NVL(A.XCH_RT_TP_CD,'V') = NVL(@[xch_rt_tp_cd],'V')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY  A.CUST_CNT_CD,A.CUST_SEQ,C.LOC_CD,A.IO_BND_CD,D.XCH_RT_RVS_FLG,B.CURR_NM,A.FM_DT,A.TO_DT,A.CHG_CURR_CD,A.LOCL_CURR_CD,A.XCH_RT_TP_CD,A.AR_OFC_CD,A.INV_XCH_RT,A.IVS_XCH_RT,A.CRE_USR_ID,A.CRE_DT,A.UPD_USR_ID,A.UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY A.AR_OFC_CD, A.FM_DT,A.TO_DT,IO_BND_CD,A.CHG_CURR_CD" ).append("\n"); 

	}
}