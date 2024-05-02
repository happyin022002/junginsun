/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VietnamCustomsTransmissionDBDAOSearchDgGoodsInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.27
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.08.27 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vietnam.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VietnamCustomsTransmissionDBDAOSearchDgGoodsInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDgGoodsInfo
	  * </pre>
	  */
	public VietnamCustomsTransmissionDBDAOSearchDgGoodsInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vietnam.integration").append("\n"); 
		query.append("FileName : VietnamCustomsTransmissionDBDAOSearchDgGoodsInfoRSQL").append("\n"); 
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
		query.append("SELECT	NVL(SUBSTR(DC.IMDG_CLSS_CD,1,7), ' ')	AS IMO_CLASS_NO" ).append("\n"); 
		query.append("       ,''                                      AS IMO_PAGE_NO  " ).append("\n"); 
		query.append("       ,NVL(SUBSTR(DC.HZD_CTNT,1,10), ' ')      AS HAZARD_CD" ).append("\n"); 
		query.append("       ,NVL(DC.IMDG_UN_NO, ' ')	                AS UNDG_NO" ).append("\n"); 
		query.append("       ,ROUND(DC.FLSH_PNT_CDO_TEMP,3) AS FLASH_POINT" ).append("\n"); 
		query.append("       ,''                             AS FLASH_POINT_UNIT" ).append("\n"); 
		query.append("       ,NVL(DC.IMDG_PCK_GRP_CD, ' ')            AS PACKING_GROUP " ).append("\n"); 
		query.append("       ,NVL(SUBSTR(DC.EMS_NO,1,6), ' ')         AS EMS_NO" ).append("\n"); 
		query.append("       ,''                                      AS MFAG" ).append("\n"); 
		query.append("       ,''                                      AS TREM_CARD_NO" ).append("\n"); 
		query.append("FROM	BKG_DG_CGO DC," ).append("\n"); 
		query.append("        BKG_BOOKING BB" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND	    BB.BKG_NO = DC.BKG_NO" ).append("\n"); 

	}
}