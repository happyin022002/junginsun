/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchCFlagJIVTERSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.24
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.06.24 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchCFlagJIVTERSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * C-Flag : I -> J -> V -> T -> E 순서
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchCFlagJIVTERSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("icr_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cus_loc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("old_c_flag",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchCFlagJIVTERSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN DECODE(@[icr_code], '1J', @[old_c_flag], 'J') = 'J'" ).append("\n"); 
		query.append("                 AND BL.PCK_QTY = SUM(DECODE(TB.ENTR_NO, 'ETC', TB.J_QTY, 0))" ).append("\n"); 
		query.append("                 AND EXISTS " ).append("\n"); 
		query.append("                 (" ).append("\n"); 
		query.append("                  SELECT 'X'" ).append("\n"); 
		query.append("                    FROM BKG_CSTMS_ADV_RSLT A" ).append("\n"); 
		query.append("                   WHERE A.BL_NO = BL.BL_NO" ).append("\n"); 
		query.append("                     AND NVL(A.RSND_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("                     AND A.BL_NVOCC_TP_CD = 'M'" ).append("\n"); 
		query.append("                     AND A.CSTMS_SEQ > (" ).append("\n"); 
		query.append("                                        SELECT MAX(CSTMS_SEQ)" ).append("\n"); 
		query.append("                                          FROM BKG_CSTMS_ADV_RSLT B" ).append("\n"); 
		query.append("                                         WHERE B.CNT_CD = A.CNT_CD" ).append("\n"); 
		query.append("                                           AND B.BL_NO= A.BL_NO" ).append("\n"); 
		query.append("                                           AND B.DSPO_CD = '1J'" ).append("\n"); 
		query.append("                                           AND NVL(B.RSND_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("                                           AND B.BL_NVOCC_TP_CD = 'M'" ).append("\n"); 
		query.append("                                           -- 최종 1J 를 찾아서" ).append("\n"); 
		query.append("                                           -- 해당 Insert 된 seq 이전 데이터 중.." ).append("\n"); 
		query.append("                                           AND B.CSTMS_SEQ < (" ).append("\n"); 
		query.append("                                                              SELECT MAX(CSTMS_SEQ)" ).append("\n"); 
		query.append("                                                                FROM BKG_CSTMS_ADV_RSLT C" ).append("\n"); 
		query.append("                                                               WHERE C.CNT_CD = A.CNT_CD" ).append("\n"); 
		query.append("                                                                 AND C.BL_NO= A.BL_NO" ).append("\n"); 
		query.append("                                                                 AND NVL(C.RSND_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("                                                                 AND C.BL_NVOCC_TP_CD = 'M'" ).append("\n"); 
		query.append("                                                             )" ).append("\n"); 
		query.append("                                       )" ).append("\n"); 
		query.append("                     -- 최종 1J 이후 11,12,13 이 있어야 I 가 됨." ).append("\n"); 
		query.append("                     AND A.DSPO_CD IN ('11','12','13')" ).append("\n"); 
		query.append("                 ) THEN 'I'" ).append("\n"); 
		query.append("            WHEN DECODE(@[icr_code], '54', DECODE(BL.MF_STS_CD, 'D', 0, BL.PCK_QTY), BL.PCK_QTY)" ).append("\n"); 
		query.append("                 = SUM(DECODE(TB.ENTR_NO, COM_ConstantMgr_PKG.COM_getCompanyCode_FNC(), TB.J_QTY, 0)) THEN 'J'" ).append("\n"); 
		query.append("            WHEN DECODE(@[icr_code], '1J', @[old_c_flag], ' ') <> 'J'" ).append("\n"); 
		query.append("                 AND DECODE(@[icr_code], '54', DECODE(BL.MF_STS_CD, 'D', 0, BL.PCK_QTY), BL.PCK_QTY)" ).append("\n"); 
		query.append("                     = SUM(DECODE(TB.ENTR_NO, 'ETC', TB.J_QTY, 0)) THEN 'V'" ).append("\n"); 
		query.append("            WHEN BL.USA_LST_LOC_CD = @[cus_loc]" ).append("\n"); 
		query.append("                 AND DECODE(@[icr_code], '54', DECODE(BL.MF_STS_CD, 'D', 0, BL.PCK_QTY), BL.PCK_QTY)" ).append("\n"); 
		query.append("                     = SUM(DECODE(TB.ENTR_NO, COM_ConstantMgr_PKG.COM_getCompanyCode_FNC(), DECODE(TB.ENTR_TP_NO, '62', TB.J_QTY, 0), 0)) THEN 'T'" ).append("\n"); 
		query.append("            WHEN BL.CSTMS_POD_CD = @[cus_loc]" ).append("\n"); 
		query.append("                 AND DECODE(@[icr_code], '54', DECODE(BL.MF_STS_CD, 'D', 0, BL.PCK_QTY), BL.PCK_QTY)" ).append("\n"); 
		query.append("                     = SUM(DECODE(TB.ENTR_NO, COM_ConstantMgr_PKG.COM_getCompanyCode_FNC(), DECODE(TB.ENTR_TP_NO, '63', TB.J_QTY, 0), 0)) THEN 'E'" ).append("\n"); 
		query.append("            ELSE 'N'" ).append("\n"); 
		query.append("       END C_FLAG" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT NVL(SUM(DECODE(CD.CSTMS_DIV_ID, 'CARGO_RLS_J_CD', RS.CNTR_QTY) * DECODE(CD.ATTR_CTNT2, 'MINUS', -1, 1)  ),0) J_QTY" ).append("\n"); 
		query.append("              ,DECODE(SUBSTR(RS.ENTR_NO, 1, 3), BKG_GET_BKG_CTMS_CD_FNC('US','AMS_ASGN_CO_CD',1,1)  , COM_ConstantMgr_PKG.COM_getCompanyCode_FNC(), 'ETC') AS ENTR_NO" ).append("\n"); 
		query.append("              ,RS.ENTR_TP_NO" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_RSLT RS" ).append("\n"); 
		query.append("              ,BKG_CSTMS_CD_CONV_CTNT CD" ).append("\n"); 
		query.append("         WHERE RS.CNT_CD        = 'US'" ).append("\n"); 
		query.append("           AND RS.BL_NO         = @[bl_no]" ).append("\n"); 
		query.append("           AND RS.CNT_CD         = CD.CNT_CD(+)" ).append("\n"); 
		query.append("           AND RS.DSPO_CD         = CD.ATTR_CTNT3(+)" ).append("\n"); 
		query.append("           AND NVL(RS.RSND_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("           AND RS.BL_NVOCC_TP_CD = 'M'" ).append("\n"); 
		query.append("      GROUP BY DECODE(SUBSTR(RS.ENTR_NO, 1, 3), BKG_GET_BKG_CTMS_CD_FNC('US','AMS_ASGN_CO_CD',1,1) , COM_ConstantMgr_PKG.COM_getCompanyCode_FNC(), 'ETC'), ENTR_TP_NO" ).append("\n"); 
		query.append("       ) TB" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_BL BL" ).append("\n"); 
		query.append(" WHERE BL.CNT_CD = 'US'" ).append("\n"); 
		query.append("   AND BL.BL_NO  = @[bl_no]" ).append("\n"); 
		query.append("GROUP BY BL.BL_NO, BL.PCK_QTY, BL.USA_LST_LOC_CD, BL.CSTMS_POD_CD, BL.MF_STS_CD" ).append("\n"); 

	}
}