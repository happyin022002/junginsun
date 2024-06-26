/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BDRCorrectionDBDAOSearchCaBkgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.15
*@LastModifier : 문경일
*@LastVersion : 1.0
* 2016.02.15 문경일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KYOUNGIL MOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BDRCorrectionDBDAOSearchCaBkgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BDRCorrectionDBDAOSearchCaBkgInfoRSQL
	  * </pre>
	  */
	public BDRCorrectionDBDAOSearchCaBkgInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.integration").append("\n"); 
		query.append("FileName : BDRCorrectionDBDAOSearchCaBkgInfoRSQL").append("\n"); 
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
		query.append("SELECT BKG.BKG_NO," ).append("\n"); 
		query.append("       BKG.BL_NO||BKG.BL_TP_CD BL_NO," ).append("\n"); 
		query.append("       (SELECT MIN(CORR_NO)" ).append("\n"); 
		query.append("          FROM BKG_CORRECTION" ).append("\n"); 
		query.append("         WHERE BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("           AND CORR_NO NOT IN ('TMP0000001', '0000000001')) CA_NO," ).append("\n"); 
		query.append("       BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD T_VVD," ).append("\n"); 
		query.append("       TO_CHAR((  SELECT SKD.VPS_ETA_DT" ).append("\n"); 
		query.append("            FROM BKG_VVD VVD, VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("            WHERE VVD.VSL_CD = SKD.VSL_CD" ).append("\n"); 
		query.append("              AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("              AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("              AND VVD.POL_CD = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("              AND VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("              AND VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("              AND ( VVD.BKG_NO, VVD.VSL_PRE_PST_CD, VVD.VSL_SEQ ) IN " ).append("\n"); 
		query.append("                      (" ).append("\n"); 
		query.append("                        SELECT VVD1.BKG_NO" ).append("\n"); 
		query.append("                             , SUBSTR(MIN(VVD1.VSL_PRE_PST_CD||VVD1.VSL_SEQ),1,1)" ).append("\n"); 
		query.append("                             , SUBSTR(MIN(VVD1.VSL_PRE_PST_CD||VVD1.VSL_SEQ),2)" ).append("\n"); 
		query.append("                          FROM BKG_VVD VVD1" ).append("\n"); 
		query.append("                         WHERE VVD.BKG_NO = VVD1.BKG_NO" ).append("\n"); 
		query.append("                         GROUP BY VVD1.BKG_NO" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("       ), 'YYYY-MM-DD') SAILED_VVD," ).append("\n"); 
		query.append("       BKG.POR_CD," ).append("\n"); 
		query.append("       SUBSTR(BKG.POR_NOD_CD, 6, 2) POR_NOD_CD," ).append("\n"); 
		query.append("       BKG.POL_CD," ).append("\n"); 
		query.append("       SUBSTR(BKG.POL_NOD_CD, 6, 2) POL_NOD_CD," ).append("\n"); 
		query.append("       BKG.POD_CD," ).append("\n"); 
		query.append("       SUBSTR(BKG.POD_NOD_CD, 6, 2) POD_NOD_CD," ).append("\n"); 
		query.append("       BKG.DEL_CD," ).append("\n"); 
		query.append("       SUBSTR(BKG.DEL_NOD_CD, 6, 2) DEL_NOD_CD," ).append("\n"); 
		query.append("       CUST.CUST_CNT_CD," ).append("\n"); 
		query.append("       CUST.CUST_SEQ," ).append("\n"); 
		query.append("       CUST.CUST_NM " ).append("\n"); 
		query.append("  FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("     , BKG_CUSTOMER CUST" ).append("\n"); 
		query.append(" WHERE BKG.BKG_NO          = CUST.BKG_NO" ).append("\n"); 
		query.append("   AND CUST.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = (  SELECT CASE" ).append("\n"); 
		query.append("                               WHEN @[bkg_no] is not null THEN @[bkg_no]" ).append("\n"); 
		query.append("                               WHEN @[bl_no] is not null THEN (SELECT BKG_NO" ).append("\n"); 
		query.append("																FROM BKG_BOOKING" ).append("\n"); 
		query.append("																WHERE BL_NO = @[bl_no])" ).append("\n"); 
		query.append("                               WHEN @[ca_no] is not null THEN ( SELECT BKG_NO " ).append("\n"); 
		query.append("                                                                  FROM BKG_CORRECTION" ).append("\n"); 
		query.append("                                                                 WHERE CORR_NO = @[ca_no]) " ).append("\n"); 
		query.append("                             END" ).append("\n"); 
		query.append("                        FROM DUAL" ).append("\n"); 
		query.append("                    )" ).append("\n"); 

	}
}