/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchSurrenderInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.26
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.11.26 이진서
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jin Seo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOSearchSurrenderInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSurrenderInfo
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchSurrenderInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOSearchSurrenderInfoRSQL").append("\n"); 
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
		query.append("BKG.BKG_NO" ).append("\n"); 
		query.append(",BKG.BL_NO||DECODE(BKG.BL_TP_CD,'W','W',DECODE(ISS.OBL_SRND_FLG, 'Y', 'S', ''))  AS BL_NO" ).append("\n"); 
		query.append(",OBL_RDEM_OFC_CD" ).append("\n"); 
		query.append(",TO_CHAR(OBL_RDEM_DT, 'YYYY-MM-DD') OBL_RDEM_DT" ).append("\n"); 
		query.append(",OBL_RDEM_KNT" ).append("\n"); 
		query.append(",OBL_RDEM_USR_ID" ).append("\n"); 
		query.append(",DIFF_RMK" ).append("\n"); 
		query.append(",OBL_SRND_FLG" ).append("\n"); 
		query.append(",BL_CPY_KNT AS OBL_ISS_KNT" ).append("\n"); 
		query.append(",OBL_RLSE_FLG" ).append("\n"); 
		query.append(",BL_TP_CD" ).append("\n"); 
		query.append(",CUST_TO_ORD_FLG" ).append("\n"); 
		query.append(",DEL_CD" ).append("\n"); 
		query.append(",BKG_STS_CD" ).append("\n"); 
		query.append(",TO_CHAR(OBL_ISS_DT, 'YYYY-MM-DD') OBL_ISS_DT" ).append("\n"); 
		query.append(",OBL_ISS_OFC_CD" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT DECODE(COUNT(bkg_no), 0, 'N','Y') AS cnt" ).append("\n"); 
		query.append("FROM bkg_do_dtl" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("bkg_no = BKG.BKG_NO" ).append("\n"); 
		query.append("AND rlse_sts_cd IN ('R', 'I')" ).append("\n"); 
		query.append(") as DO_ISUUE" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT SUBSTR(LOC_CD, 1, 2)" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = OBL_ISS_OFC_CD" ).append("\n"); 
		query.append(") AS CNT_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_BOOKING BKG ,BKG_BL_ISS ISS" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND  BKG.BKG_NO = ISS.BKG_NO(+)" ).append("\n"); 

	}
}