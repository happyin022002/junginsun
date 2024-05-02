/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiPodAtaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchDblEdiPodAtaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiPodAtaRSQL(){
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
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiPodAtaRSQL").append("\n"); 
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
		query.append("SELECT 'POD_ATA:' || NVL(TO_CHAR(DECODE(C.PORT_SKD_STS_CD,'D',C.VPS_ETA_DT, (SELECT ACT_ARR_DT " ).append("\n"); 
		query.append("                                                                              FROM VSK_ACT_PORT_SKD" ).append("\n"); 
		query.append("                                                                             WHERE C.VSL_CD = VSL_CD" ).append("\n"); 
		query.append("                                                                               AND NVL(C.TURN_SKD_VOY_NO,C.SKD_VOY_NO) = SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                               AND NVL(C.TURN_SKD_DIR_CD,C.SKD_DIR_CD) = SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                               AND C.VPS_PORT_CD = VPS_PORT_CD" ).append("\n"); 
		query.append("                                                                               AND NVL(C.TURN_CLPT_IND_SEQ,C.CLPT_IND_SEQ) = CLPT_IND_SEQ)), 'YYYYMMDDHH24MI'), ' ') || CHR(10)" ).append("\n"); 
		query.append("FROM   BKG_VVD A, BKG_BOOKING B,VSK_VSL_PORT_SKD C" ).append("\n"); 
		query.append("WHERE  A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("   AND A.POD_CD = B.POD_CD" ).append("\n"); 
		query.append("   AND C.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("   AND C.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND C.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND C.VPS_PORT_CD = A.POD_CD" ).append("\n"); 
		query.append("   AND C.CLPT_IND_SEQ = A.POD_CLPT_IND_SEQ" ).append("\n"); 

	}
}