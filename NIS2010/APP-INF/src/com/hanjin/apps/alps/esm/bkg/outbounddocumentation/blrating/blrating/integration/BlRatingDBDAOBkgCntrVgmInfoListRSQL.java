/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : BlRatingDBDAOBkgCntrVgmInfoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.13
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOBkgCntrVgmInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * get booking container vgm list
	  * </pre>
	  */
	public BlRatingDBDAOBkgCntrVgmInfoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOBkgCntrVgmInfoListRSQL").append("\n"); 
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
		query.append("SELECT CNTR_NO, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , DECODE(VGM_WGT_UT_CD, 'LBS', NVL(VGM_WGT, 0) * 0.45359237, NVL(VGM_WGT, 0)) / 1000 AS VGM_WGT" ).append("\n"); 
		query.append("     , (CASE WHEN (SUM(CASE WHEN NVL(VGM_WGT, 0) = 0" ).append("\n"); 
		query.append("                               THEN 0" ).append("\n"); 
		query.append("                            ELSE CNTR_VOL_QTY" ).append("\n"); 
		query.append("                        END) OVER ()) < (SELECT SUM(OP_CNTR_QTY) FROM BKG_QTY_DTL WHERE BKG_NO = A.BKG_NO)" ).append("\n"); 
		query.append("                THEN 'N'" ).append("\n"); 
		query.append("             ELSE 'Y'" ).append("\n"); 
		query.append("         END) AS FIN_FLG" ).append("\n"); 
		query.append("  FROM BKG_CONTAINER A" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND 'N' = @[ca_flg]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT CNTR_NO, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , DECODE(VGM_WGT_UT_CD, 'LBS', NVL(VGM_WGT, 0) * 0.45359237, NVL(VGM_WGT, 0)) / 1000 AS VGM_WGT" ).append("\n"); 
		query.append("     , (CASE WHEN (SUM(CASE WHEN NVL(VGM_WGT, 0) = 0" ).append("\n"); 
		query.append("                               THEN 0" ).append("\n"); 
		query.append("                            ELSE CNTR_VOL_QTY" ).append("\n"); 
		query.append("                        END) OVER ()) < (SELECT SUM(OP_CNTR_QTY) FROM BKG_QTY_DTL_HIS WHERE BKG_NO = A.BKG_NO AND CORR_NO = A.CORR_NO)" ).append("\n"); 
		query.append("                THEN 'N'" ).append("\n"); 
		query.append("             ELSE 'Y'" ).append("\n"); 
		query.append("         END) AS FIN_FLG" ).append("\n"); 
		query.append("  FROM BKG_CNTR_HIS A" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("   AND 'Y' = @[ca_flg]" ).append("\n"); 

	}
}