/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CsScreenDBDAOsearchCntrSoInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 윤윤한
*@LastVersion : 1.0
* 2010.01.13 윤윤한
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YYN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CsScreenDBDAOsearchCntrSoInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 고객 응대를 위한 Container별 S/O & W/O 발행 Status 정보를 조회한다.
	  * </pre>
	  */
	public CsScreenDBDAOsearchCntrSoInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration").append("\n"); 
		query.append("FileName : CsScreenDBDAOsearchCntrSoInfoRSQL").append("\n"); 
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
		query.append("SELECT  WO_OFC_CTY_CD," ).append("\n"); 
		query.append("WO_SEQ," ).append("\n"); 
		query.append("CNTR_NO," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("BND_CD," ).append("\n"); 
		query.append("REQ_CNT," ).append("\n"); 
		query.append("ISS_CNT," ).append("\n"); 
		query.append("POD_CD," ).append("\n"); 
		query.append("DEL_CD," ).append("\n"); 
		query.append("STS_CD," ).append("\n"); 
		query.append("DE_TERM_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT TRSP_SO_OFC_CTY_CD               SO_OFC_CTY_CD," ).append("\n"); 
		query.append("TRSP_SO_SEQ                      SO_SEQ," ).append("\n"); 
		query.append("TRSP_WO_OFC_CTY_CD               WO_OFC_CTY_CD," ).append("\n"); 
		query.append("TRSP_WO_SEQ                      WO_SEQ," ).append("\n"); 
		query.append("EQ_NO                            CNTR_NO,         -- CONTAINER NO" ).append("\n"); 
		query.append("EQ_TPSZ_CD                       CNTR_TPSZ_CD,      -- TP/SZ" ).append("\n"); 
		query.append("DECODE(TRSP_BND_CD, 'I', 'I/B')  BND_CD,              -- BOUND" ).append("\n"); 
		query.append("COUNT(*) OVER (PARTITION BY BKG_NO, EQ_NO , TRSP_BND_CD) REQ_CNT,  -- S/O REQUIRED" ).append("\n"); 
		query.append("SUM(DECODE(TRSP_SO_STS_CD, 'C', 1, 'I', 1, 'R', 1, 0)) OVER (PARTITION BY BKG_NO, EQ_NO , TRSP_BND_CD) ISS_CNT,  -- S/O ISSUED" ).append("\n"); 
		query.append("POD_CD                           POD_CD,         -- POD" ).append("\n"); 
		query.append("DEL_CD                           DEL_CD,         -- DEL" ).append("\n"); 
		query.append("BKG_RCVDE_TERM_CD                DE_TERM_CD,     -- DELIEVERY TERM" ).append("\n"); 
		query.append("DECODE(TRSP_SO_STS_CD,'P','SO PLANNED'" ).append("\n"); 
		query.append(",'C','S/O ISSUE'" ).append("\n"); 
		query.append(",'I','W/O ISSUE'" ).append("\n"); 
		query.append(",'EXCUTED')  STS_CD,        -- LAS S/O STATUS" ).append("\n"); 
		query.append("MAX(TRSP_SO_SEQ) OVER (PARTITION BY BKG_NO, EQ_NO , TRSP_BND_CD) MAX_SO_SEQ" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND   TRSP_BND_CD='I'" ).append("\n"); 
		query.append("AND   DELT_FLG = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE SO_SEQ = MAX_SO_SEQ" ).append("\n"); 

	}
}