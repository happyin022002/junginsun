/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingARCreationDBDAOSearchWhfDiffCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOSearchWhfDiffCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG과 INV간 WHF 금액 Diff Check
	  * </pre>
	  */
	public BookingARCreationDBDAOSearchWhfDiffCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOSearchWhfDiffCheckRSQL").append("\n"); 
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
		query.append("WITH INV_WHF AS (" ).append("\n"); 
		query.append("                SELECT MN.BL_SRC_NO, MN.AR_OFC_CD, MN.IO_BND_CD, CHG.CURR_CD, CHG.CHG_CD, SUM(CHG.CHG_AMT) CHG_AMT, MAX(MN.WHF_DECL_NO) WHF_DECL_NO" ).append("\n"); 
		query.append("                FROM   INV_AR_MN MN," ).append("\n"); 
		query.append("                       INV_AR_CHG CHG" ).append("\n"); 
		query.append("                WHERE  MN.AR_IF_NO = CHG.AR_IF_NO" ).append("\n"); 
		query.append("                AND    MN.BL_SRC_NO = @[bkg_no]" ).append("\n"); 
		query.append("                AND    MN.INV_DELT_DIV_CD <> 'Y'" ).append("\n"); 
		query.append("                AND    MN.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("                AND    CHG.CHG_CD = 'WHF'" ).append("\n"); 
		query.append("                GROUP BY MN.BL_SRC_NO, MN.AR_OFC_CD, MN.IO_BND_CD, CHG.CURR_CD, CHG.CHG_CD" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("SELECT  DECODE(SUM(WHF_DIFF), 0, 'N', 'Y') WHF_DIFF_CHK" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("                   INV.BL_SRC_NO," ).append("\n"); 
		query.append("                   INV.AR_OFC_CD," ).append("\n"); 
		query.append("                   INV.IO_BND_CD," ).append("\n"); 
		query.append("                   INV.CURR_CD," ).append("\n"); 
		query.append("                   INV.CHG_CD," ).append("\n"); 
		query.append("                   INV.CHG_AMT," ).append("\n"); 
		query.append("                   INV.WHF_DECL_NO," ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                   CASE WHEN LENGTH(INV.WHF_DECL_NO) > 0 THEN" ).append("\n"); 
		query.append("                        NVL(((SELECT SUM(CHG_AMT) FROM INV_WHF WHERE WHF_DECL_NO IS NOT NULL)-KR_WHF.NEW_CHG_AMT),0)" ).append("\n"); 
		query.append("                   ELSE " ).append("\n"); 
		query.append("                        NVL((INV.CHG_AMT-BKG_WHF.CHG_AMT),0)" ).append("\n"); 
		query.append("                   END WHF_DIFF" ).append("\n"); 
		query.append("            FROM   INV_WHF INV," ).append("\n"); 
		query.append("                   (" ).append("\n"); 
		query.append("                    SELECT  BL_NO,  SUM(NEW_CHG_AMT) NEW_CHG_AMT --,   MAX(WHF_DECL_NO) MAX_WHF_DECL_NO, WHF_BND_CD," ).append("\n"); 
		query.append("                    FROM    BKG_KR_WHF_RT" ).append("\n"); 
		query.append("                    WHERE   BL_NO = @[bkg_no]" ).append("\n"); 
		query.append("                    AND     WHF_DECL_NO IS NOT NULL" ).append("\n"); 
		query.append("                    GROUP BY BL_NO--, WHF_BND_CD" ).append("\n"); 
		query.append("                   ) KR_WHF," ).append("\n"); 
		query.append("                   (" ).append("\n"); 
		query.append("                    SELECT  BKG_NO, FRT_TERM_CD, CHG_CD, CURR_CD, SUM(CHG_AMT) CHG_AMT" ).append("\n"); 
		query.append("                    FROM    BKG_CHG_RT" ).append("\n"); 
		query.append("                    WHERE   BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                    AND     CHG_CD = 'WHF'" ).append("\n"); 
		query.append("                    GROUP BY BKG_NO, FRT_TERM_CD, CHG_CD, CURR_CD" ).append("\n"); 
		query.append("                   ) BKG_WHF" ).append("\n"); 
		query.append("            WHERE  INV.BL_SRC_NO = KR_WHF.BL_NO(+)" ).append("\n"); 
		query.append("            AND    INV.BL_SRC_NO = BKG_WHF.BKG_NO(+)" ).append("\n"); 
		query.append("            AND    INV.CHG_AMT <> 0" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}