/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CsScreenDBDAOsearchUsCstmsRstInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.16
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.10.16 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CsScreenDBDAOsearchUsCstmsRstInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchUsCstmsRstInfo
	  * </pre>
	  */
	public CsScreenDBDAOsearchUsCstmsRstInfoRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration").append("\n"); 
		query.append("FileName : CsScreenDBDAOsearchUsCstmsRstInfoRSQL").append("\n"); 
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
		query.append("SELECT  DSPO_CD" ).append("\n"); 
		query.append("     , CSTMS_CLR_CD" ).append("\n"); 
		query.append("     , CNTR_QTY" ).append("\n"); 
		query.append("     , ENTR_TP_NO" ).append("\n"); 
		query.append("     , ENTR_NO" ).append("\n"); 
		query.append("     , TO_CHAR(ARR_DT,'yyyymmdd hh24MI') AS ARR_DT" ).append("\n"); 
		query.append("     , RCV_LOC_CD" ).append("\n"); 
		query.append("     , CSTMS_RMK1 || CSTMS_RMK2 || CSTMS_RMK3 AS CSTMS_RMK1 " ).append("\n"); 
		query.append("     , RM.SCAC_CD AS SCAC_CD" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BKGM" ).append("\n"); 
		query.append("     , BKG_CSTMS_ADV_RSLT CRST" ).append("\n"); 
		query.append("     , BKG_CSTMS_ADV_RCV_LOG RM" ).append("\n"); 
		query.append(" WHERE BKGM.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("   AND CRST.CNT_CD       = @[cnt_cd]" ).append("\n"); 
		query.append("   AND CRST.BL_NO        = BKGM.BL_NO" ).append("\n"); 
		query.append("   AND CRST.CNT_CD       = RM.CNT_CD(+)" ).append("\n"); 
		query.append("   AND RM.IO_BND_CD(+)   = 'I'" ).append("\n"); 
		query.append("   AND CRST.VSL_CD       = RM.VSL_CD(+)" ).append("\n"); 
		query.append("   AND CRST.SKD_VOY_NO   = RM.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND CRST.SKD_DIR_CD   = RM.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND CRST.ARR_DT       = RM.RCV_DT(+)" ).append("\n"); 
		query.append("   AND CRST.CSTMS_BAT_NO = RM.CSTMS_BAT_NO(+)" ).append("\n"); 
		query.append("ORDER BY ARR_DT,CSTMS_SEQ, ENTR_TP_NO" ).append("\n"); 

	}
}