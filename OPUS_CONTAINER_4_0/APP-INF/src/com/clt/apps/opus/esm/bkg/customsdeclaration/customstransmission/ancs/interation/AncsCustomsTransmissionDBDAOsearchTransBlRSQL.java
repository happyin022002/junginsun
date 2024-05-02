/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AncsCustomsTransmissionDBDAOsearchTransBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.05
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.10.05 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.interation;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AncsCustomsTransmissionDBDAOsearchTransBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SELECT
	  * </pre>
	  */
	public AncsCustomsTransmissionDBDAOsearchTransBlRSQL(){
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
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.interation").append("\n"); 
		query.append("FileName : AncsCustomsTransmissionDBDAOsearchTransBlRSQL").append("\n"); 
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
		query.append("SELECT A.*" ).append("\n"); 
		query.append("      ,'' AS STATUS" ).append("\n"); 
		query.append("      ,LPAD(REF_SEQ, 6, '0')     AS SEQUENCE" ).append("\n"); 
		query.append("      ,LPAD(REF_SEQ - 1, 6, '0') AS PREV_DOCNO" ).append("\n"); 
		query.append("  FROM (SELECT BL.VSL_CD || BL.SKD_VOY_NO || BL.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("              ,VVD.LLOYD_TP_CD || VVD.LLOYD_NO             AS LLOYD_CD" ).append("\n"); 
		query.append("              ,VVD.SVC_RQST_NO                             AS SS_REF_NO" ).append("\n"); 
		query.append("              ,(SELECT NVL(MAX(REF_SEQ), 0) + 1 " ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_ANR_EDI_HIS AA" ).append("\n"); 
		query.append("                 WHERE AA.ANR_DECL_NO = VVD.SVC_RQST_NO || VVD.LLOYD_TP_CD || VVD.LLOYD_NO" ).append("\n"); 
		query.append("                   AND AA.MSG_TP_CD = 'C' " ).append("\n"); 
		query.append("               ) AS REF_SEQ" ).append("\n"); 
		query.append("              ,BL.ACT_WGT AS WGT" ).append("\n"); 
		query.append("              ,BL.ACT_WGT_UT_CD AS WGT_U" ).append("\n"); 
		query.append("              ,LPAD(BL.VVD_SEQ, 4, '0') AS ART_NO" ).append("\n"); 
		query.append("              ,BL.BL_NO" ).append("\n"); 
		query.append("              ,(SELECT MVMT_REF_NO" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_EUR_BL AA" ).append("\n"); 
		query.append("                 WHERE AA.VSL_CD     = BL.VSL_CD" ).append("\n"); 
		query.append("                   AND AA.SKD_VOY_NO = BL.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND AA.SKD_DIR_CD = BL.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND AA.BL_NO      = BL.BL_NO" ).append("\n"); 
		query.append("                   AND AA.CSTMS_PORT_CD = BL.POD_CD" ).append("\n"); 
		query.append("               ) AS MRN" ).append("\n"); 
		query.append("              ,BL.PCK_QTY AS PKG" ).append("\n"); 
		query.append("              ,BL.POD_CD  AS POD" ).append("\n"); 
		query.append("              ,VVD.BRTH_DESC AS BERTH_CD" ).append("\n"); 
		query.append("              ,BL.POL_CD  AS POL" ).append("\n"); 
		query.append("              ,BL.PRE_RLY_PORT_CD AS PRE" ).append("\n"); 
		query.append("              ,BL.PST_RLY_PORT_CD AS POST" ).append("\n"); 
		query.append("              ,BL.POR_CD          AS POR" ).append("\n"); 
		query.append("              ,BL.DEL_CD          AS DEL" ).append("\n"); 
		query.append("              ,SUBSTR(BKG_TOKEN_NL_FNC(" ).append("\n"); 
		query.append("                 SUBSTR(BL.SHPR_ADDR, 1, INSTR(BL.SHPR_ADDR, '@@', 1) -1)" ).append("\n"); 
		query.append("                 ,0,''),1,175)               AS SHPR_NAME" ).append("\n"); 
		query.append("              ,SUBSTR(BKG_TOKEN_NL_FNC(" ).append("\n"); 
		query.append("                 SUBSTR(BL.SHPR_ADDR, INSTR(BL.SHPR_ADDR, '@@', 1) + 2)" ).append("\n"); 
		query.append("                 ,0,''),1,105)               AS SHPR_ADDR" ).append("\n"); 
		query.append("              ,SUBSTR(BKG_TOKEN_NL_FNC(" ).append("\n"); 
		query.append("                 SUBSTR(BL.CNEE_ADDR, 1, INSTR(BL.CNEE_ADDR, '@@', 1) -1)" ).append("\n"); 
		query.append("                 ,0,''),1,175)               AS CNEE_NAME" ).append("\n"); 
		query.append("              ,SUBSTR(BKG_TOKEN_NL_FNC(" ).append("\n"); 
		query.append("                 SUBSTR(BL.CNEE_ADDR, INSTR(BL.CNEE_ADDR, '@@', 1) + 2)" ).append("\n"); 
		query.append("                 ,0,''),1,105)               AS CNEE_ADDR" ).append("\n"); 
		query.append("              ,SUBSTR(BKG_TOKEN_NL_FNC(NTFY.NTFY_NM,0,''),1,175)   AS NTFY_NAME" ).append("\n"); 
		query.append("              ,SUBSTR(BKG_TOKEN_NL_FNC(NTFY.NTFY_ADDR,0,''),1,105) AS NTFY_ADDR" ).append("\n"); 
		query.append("              ,BL.BKG_NO" ).append("\n"); 
		query.append("              ,BL.VSL_CD" ).append("\n"); 
		query.append("              ,BL.SKD_VOY_NO" ).append("\n"); 
		query.append("              ,BL.SKD_DIR_CD" ).append("\n"); 
		query.append("              ,NVL(BL.ANR_MSG_STS_CD, 'N') AS ANR_MSG_STS_CD" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ANR_BL   BL" ).append("\n"); 
		query.append("              ,BKG_CSTMS_ANR_VVD  VVD" ).append("\n"); 
		query.append("              ,BKG_CSTMS_ANR_NTFY NTFY" ).append("\n"); 
		query.append("         WHERE BL.VSL_CD     = VVD.VSL_CD" ).append("\n"); 
		query.append("           AND BL.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND BL.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND BL.BKG_NO     = NTFY.BKG_NO(+)" ).append("\n"); 
		query.append("           AND NTFY.NTFY_SEQ(+) = 1" ).append("\n"); 
		query.append("           AND BL.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("  		   AND BL.VSL_CD     = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("		   AND BL.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append(" 		   AND BL.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("           ) A" ).append("\n"); 

	}
}