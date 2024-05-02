/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchUsaTmlBlByVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.01
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchUsaTmlBlByVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaTmlBlByVvdVO
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchUsaTmlBlByVvdRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchUsaTmlBlByVvdRSQL").append("\n"); 
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
		query.append("SELECT TB.*" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT /*+ ORDERED */ BL.BL_NO" ).append("\n"); 
		query.append("              ,BL.BKG_NO" ).append("\n"); 
		query.append("              ,BL.VSL_CD" ).append("\n"); 
		query.append("              ,BL.SKD_VOY_NO" ).append("\n"); 
		query.append("              ,BL.SKD_DIR_CD" ).append("\n"); 
		query.append("              ,BL.CSTMS_POL_CD" ).append("\n"); 
		query.append("              ,BL.CSTMS_POD_CD" ).append("\n"); 
		query.append("              ,BL.POL_CD" ).append("\n"); 
		query.append("              ,BL.POD_CD" ).append("\n"); 
		query.append("              ,BL.POD_NOD_CD" ).append("\n"); 
		query.append("              ,C.CNTR_NO" ).append("\n"); 
		query.append("              ,BKG.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("              ,SKD.YD_CD" ).append("\n"); 
		query.append("              ,EDI.SNDR_TRD_PRNR_ID AS SND_ID" ).append("\n"); 
		query.append("              ,EDI.RCVR_TRD_PRNR_ID AS RCV_ID" ).append("\n"); 
		query.append("              ,ROW_NUMBER() OVER(PARTITION BY BL.BKG_NO, C.CNTR_NO, EDI.PRNR_SUB_LNK_CD ORDER BY TRD_PRNR_SUB_LNK_SEQ) AS RNUM" ).append("\n"); 
		query.append("			  ,BL.MF_STS_CD " ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_BL BL" ).append("\n"); 
		query.append("              ,BKG_CSTMS_ADV_CNTR C" ).append("\n"); 
		query.append("              ,BKG_BOOKING BKG" ).append("\n"); 
		query.append("              ,VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("              ,BKG_EDI_TRD_PRNR_SUB_LNK EDI" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			  ,BKG_BL_DOC DOC" ).append("\n"); 
		query.append("         WHERE BL.CNT_CD = C.CNT_CD" ).append("\n"); 
		query.append("           AND BL.BL_NO = C.BL_NO" ).append("\n"); 
		query.append("           AND BL.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("           AND BL.VSL_CD = SKD.VSL_CD" ).append("\n"); 
		query.append("           AND BL.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND BL.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND BL.CSTMS_POD_CD = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("           AND SKD.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("           AND SKD.YD_CD IN ('USLGBPT', 'USOAKM1', 'USLAXYM','USSEAM1' ,'USTIWYM', 'USLAXM4', 'USOAKM7')" ).append("\n"); 
		query.append("           AND SKD.YD_CD = EDI.PRNR_SUB_LNK_CD" ).append("\n"); 
		query.append("           AND EDI.SNDR_TRD_PRNR_ID = COM_ConstantMgr_PKG.COM_getScacCode_FNC()" ).append("\n"); 
		query.append("           AND BL.CNT_CD = 'US'" ).append("\n"); 
		query.append("           AND BL.MF_NO IS NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("           AND NVL(DOC.BDR_FLG, 'N') = 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bl_no} != '') " ).append("\n"); 
		query.append("           AND BL.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("           AND BL.BL_NO IN (${bl_nos})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ) TB" ).append("\n"); 
		query.append(" WHERE TB.RNUM = 1" ).append("\n"); 

	}
}