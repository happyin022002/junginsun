/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UnmatchBLDBDAORsltSearchBkgStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.18
*@LastModifier : 
*@LastVersion : 1.0
* 2012.12.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAORsltSearchBkgStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBkgStatus
	  * </pre>
	  */
	public UnmatchBLDBDAORsltSearchBkgStatusRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAORsltSearchBkgStatusRSQL").append("\n"); 
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
		query.append("SELECT  BK.BKG_STS_CD ," ).append("\n"); 
		query.append("        'N'   CA_FLG  ," ).append("\n"); 
		query.append("        NVL(BR.CALC_CTRT_TP_CD,BR.BKG_CTRT_TP_CD) CTRT_TP_CD  ," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  CORR_NO" ).append("\n"); 
		query.append("        FROM    (" ).append("\n"); 
		query.append("                SELECT  CORR_NO ," ).append("\n"); 
		query.append("                        ROW_NUMBER() OVER ( PARTITION BY BKG_NO ORDER BY CORR_GDT DESC ) ROW_NUMBER" ).append("\n"); 
		query.append("                FROM    BKG_CORRECTION" ).append("\n"); 
		query.append("                WHERE   BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("                AND     CORR_NO <> 'TMP0000001'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        WHERE   ROW_NUMBER  = 1" ).append("\n"); 
		query.append("        ) CORR_NO       ," ).append("\n"); 
		query.append("        BK.SVC_SCP_CD	," ).append("\n"); 
		query.append("        (SELECT ATTR_CTNT1 " ).append("\n"); 
		query.append("         FROM BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("         WHERE HRD_CDG_ID = 'SC_AUTORATING_TYPE' " ).append("\n"); 
		query.append("         AND ATTR_CTNT2 = SVC_SCP_CD) SC_RT_TP   ," ).append("\n"); 
		query.append("        (SELECT CASE WHEN SUBSTR(BK.POR_CD,1,2) IN ('US','CA') OR SUBSTR(BK.DEL_CD,1,2) IN ('US','CA') THEN 'N'" ).append("\n"); 
		query.append("                     WHEN BR.RT_APLY_DT >= TO_DATE(ATTR_CTNT2,'YYYYMMDD') " ).append("\n"); 
		query.append("                          AND BR.RT_APLY_DT <= TO_DATE(ATTR_CTNT3,'YYYYMMDD')" ).append("\n"); 
		query.append("                          AND (SELECT D.CTRT_EFF_DT " ).append("\n"); 
		query.append("                               FROM PRI_RP_HDR H, PRI_RP_DUR D" ).append("\n"); 
		query.append("                               WHERE H.RFA_NO = BK.RFA_NO" ).append("\n"); 
		query.append("                               AND H.PROP_NO = D.PROP_NO" ).append("\n"); 
		query.append("                               AND BR.RT_APLY_DT BETWEEN D.CTRT_EFF_DT AND D.CTRT_EXP_DT" ).append("\n"); 
		query.append("                               AND ROWNUM = 1) < TO_DATE(ATTR_CTNT2,'YYYYMMDD') THEN 'Y'" ).append("\n"); 
		query.append("                     WHEN BR.RT_APLY_DT >=  TO_DATE(ATTR_CTNT2,'YYYYMMDD') THEN 'FIC'" ).append("\n"); 
		query.append("                     WHEN BR.RT_APLY_DT BETWEEN TO_DATE(ATTR_CTNT1,'YYYYMMDD') AND TO_DATE(ATTR_CTNT2,'YYYYMMDD') THEN 'Y'" ).append("\n"); 
		query.append("                     ELSE 'N'" ).append("\n"); 
		query.append("                END HINTER_FLG" ).append("\n"); 
		query.append("         FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("         WHERE HRD_CDG_ID = 'HINTERLAND_APLY_FLG') HINTER_FLG" ).append("\n"); 
		query.append("FROM    BKG_BOOKING BK  ," ).append("\n"); 
		query.append("        BKG_RATE    BR" ).append("\n"); 
		query.append("WHERE   BR.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("AND     BK.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}