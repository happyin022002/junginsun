/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOSearchManualInterfaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.02
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2011.06.02 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOSearchManualInterfaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INV_AR_MN 테이블에서 select
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOSearchManualInterfaceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_if_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_if_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOSearchManualInterfaceRSQL").append("\n"); 
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
		query.append("SELECT MAX(DECODE(CHG.IO_BND_CD, 'O', CHG.OFC_CD, NULL)) PPD_OFC" ).append("\n"); 
		query.append("      ,MAX(DECODE(CHG.IO_BND_CD, 'I', CHG.OFC_CD, NULL)) CCT_OFC" ).append("\n"); 
		query.append("      ,MN.TRNK_VSL_CD||MN.TRNK_SKD_VOY_NO||MN.TRNK_SKD_DIR_CD TRNK_VVD" ).append("\n"); 
		query.append("      ,MN.BL_SRC_NO" ).append("\n"); 
		query.append("      ,MN.SRC_IF_DT" ).append("\n"); 
		query.append("      ,MN.POL_CD" ).append("\n"); 
		query.append("      ,MN.POD_CD" ).append("\n"); 
		query.append("      ,MN.BKG_NO" ).append("\n"); 
		query.append("      ,MN.BKG_SEQ" ).append("\n"); 
		query.append("	  ,MN.INV_AR_IF_CD" ).append("\n"); 
		query.append("	  ,MN.AR_IF_ERR_RSN" ).append("\n"); 
		query.append("  FROM INV_BKG_IF_MN MN" ).append("\n"); 
		query.append("      ,INV_BKG_IF_CHG CHG" ).append("\n"); 
		query.append(" WHERE MN.BKG_NO = CHG.BKG_NO(+)" ).append("\n"); 
		query.append("  AND MN.BKG_SEQ = CHG.BKG_SEQ(+)" ).append("\n"); 
		query.append("  AND MN.INV_BAT_CD = 'Y' " ).append("\n"); 
		query.append("  AND MN.INV_AR_IF_CD ='E'" ).append("\n"); 
		query.append("#if (${fm_if_dt} !=''&&${to_if_dt}!='')" ).append("\n"); 
		query.append("  AND MN.SRC_IF_DT >= REPLACE(@[fm_if_dt],'-','') " ).append("\n"); 
		query.append("  AND MN.SRC_IF_DT <= REPLACE(@[to_if_dt],'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trnk_vvd} !='')" ).append("\n"); 
		query.append("   AND MN.TRNK_VSL_CD = SUBSTR(@[trnk_vvd],1,4)" ).append("\n"); 
		query.append("   AND MN.TRNK_SKD_VOY_NO = SUBSTR(@[trnk_vvd],5,4)" ).append("\n"); 
		query.append("   AND MN.TRNK_SKD_DIR_CD = SUBSTR(@[trnk_vvd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_src_no} !='')" ).append("\n"); 
		query.append("   AND MN.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} !='')" ).append("\n"); 
		query.append("   AND MN.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} !='')" ).append("\n"); 
		query.append("   AND MN.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND (MN.BKG_NO, MN.BKG_SEQ) IN ( SELECT BKG_NO, MAX(BKG_SEQ)" ).append("\n"); 
		query.append("                               FROM INV_BKG_IF_MN" ).append("\n"); 
		query.append("                              WHERE BKG_NO = MN.BKG_NO " ).append("\n"); 
		query.append("#if (${fm_if_dt} !=''&&${to_if_dt}!='')" ).append("\n"); 
		query.append("                                AND SRC_IF_DT >= REPLACE(@[fm_if_dt],'-','')" ).append("\n"); 
		query.append("                                AND SRC_IF_DT <= TO_CHAR(SYSDATE,'YYYYMMDD') " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("                              GROUP BY BKG_NO )" ).append("\n"); 
		query.append("GROUP BY MN.TRNK_VSL_CD||MN.TRNK_SKD_VOY_NO||MN.TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("      ,MN.BL_SRC_NO" ).append("\n"); 
		query.append("      ,MN.SRC_IF_DT" ).append("\n"); 
		query.append("      ,MN.POL_CD" ).append("\n"); 
		query.append("      ,MN.POD_CD" ).append("\n"); 
		query.append("      ,MN.BKG_NO" ).append("\n"); 
		query.append("      ,MN.BKG_SEQ" ).append("\n"); 
		query.append("      ,MN.INV_AR_IF_CD" ).append("\n"); 
		query.append("	  ,MN.AR_IF_ERR_RSN" ).append("\n"); 

	}
}