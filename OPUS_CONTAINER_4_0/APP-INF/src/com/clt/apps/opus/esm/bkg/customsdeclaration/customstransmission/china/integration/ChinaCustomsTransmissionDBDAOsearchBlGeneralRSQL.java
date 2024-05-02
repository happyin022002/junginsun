/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChinaCustomsTransmissionDBDAOsearchBlGeneralRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaCustomsTransmissionDBDAOsearchBlGeneralRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChinaBlGeneralListVO
	  * </pre>
	  */
	public ChinaCustomsTransmissionDBDAOsearchBlGeneralRSQL(){
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
		params.put("trans_mode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration").append("\n"); 
		query.append("FileName : ChinaCustomsTransmissionDBDAOsearchBlGeneralRSQL").append("\n"); 
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
		query.append("SELECT  BL.BL_NO," ).append("\n"); 
		query.append("        DECODE(RK.TRSM_MSG_TP_ID,'9','Original','0','Secondly','5','Change','3','Delete') AS TRSM_MSG_TP_ID," ).append("\n"); 
		query.append("        TO_CHAR(RK.MF_SND_DT,'YYYY-MM-DD HH24:MI:SS') AS MF_SND_DT," ).append("\n"); 
		query.append("        BL.BKG_NO," ).append("\n"); 
		query.append("        BL.VSL_CD||BL.SKD_VOY_NO||BL.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("		VSL.VSL_ENG_NM||' '||BL.SKD_VOY_NO||BL.SKD_DIR_CD AS VSL_NM," ).append("\n"); 
		query.append("        TO_CHAR(NVL(BL.BL_OBRD_DT,(SELECT MAX(V.VPS_ETB_DT)" ).append("\n"); 
		query.append("                    FROM VSK_VSL_PORT_SKD V, BKG_VVD B" ).append("\n"); 
		query.append("                    WHERE V.VSL_CD = BL.VSL_CD" ).append("\n"); 
		query.append("                    AND V.SKD_VOY_NO = BL.SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND V.SKD_DIR_CD = BL.SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND V.VPS_PORT_CD = BL.PORT_CD" ).append("\n"); 
		query.append("                    AND B.BKG_NO = BL.BKG_NO AND B.VSL_CD = V.VSL_CD AND B.SKD_VOY_NO = V.SKD_VOY_NO AND B.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND V.CLPT_IND_SEQ = DECODE(B.POL_CD,BL.PORT_CD,B.POL_CLPT_IND_SEQ,B.POD_CLPT_IND_SEQ))),'YYYY-MM-DD') AS BL_OBRD_DT," ).append("\n"); 
		query.append("        TO_CHAR(BL.BL_ISS_DT, 'YYYY-MM-DD') AS BL_ISS_DT," ).append("\n"); 
		query.append("        BL.POR_CD," ).append("\n"); 
		query.append("        BL.POL_CD," ).append("\n"); 
		query.append("        BL.POD_CD," ).append("\n"); 
		query.append("        BL.DEL_CD," ).append("\n"); 
		query.append("        BL.PORT_CD," ).append("\n"); 
		query.append("        BL.RCV_TERM_CD," ).append("\n"); 
		query.append("        BL.DE_TERM_CD," ).append("\n"); 
		query.append("        BL.FRT_TERM_CD," ).append("\n"); 
		query.append("		BL.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("		NVL(RF.RF_SEQ_NO, '1') AS RF_SEQ_NO," ).append("\n"); 
		query.append("        DECODE(RF.FDO_TEMP, NULL, DECODE(RF.CDO_TEMP, NULL, '0.0', RF.CDO_TEMP), RF.FDO_TEMP) AS TEMP," ).append("\n"); 
		query.append("        DECODE(RF.FDO_TEMP, NULL, 'C', 'F') AS TEMP_UNIT," ).append("\n"); 
		query.append("        BL.CHN_CSTMS_TRSP_MOD_CD AS TRSP_MOD_ID," ).append("\n"); 
		query.append("        BL.PCK_QTY," ).append("\n"); 
		query.append("        BL.PCK_TP_CD," ).append("\n"); 
		query.append("        BL.ACT_WGT," ).append("\n"); 
		query.append("        BL.WGT_UT_CD," ).append("\n"); 
		query.append("        BL.MEAS_QTY," ).append("\n"); 
		query.append("        BL.MEAS_UT_CD," ).append("\n"); 
		query.append("        BL.CSTMS_DESC," ).append("\n"); 
		query.append("        REPLACE(REPLACE(REPLACE(NVL(MKD.CMDT_DESC, ' '), CHR(10),'@*'), CHR(34),' '),CHR(9),' ') AS CMDT_DESC2," ).append("\n"); 
		query.append("        REPLACE(REPLACE(REPLACE(NVL(MK.BL_MK_DESC, ' '), CHR(10),'@*'), CHR(34),' '),CHR(9),' ') AS BL_MK_DESC," ).append("\n"); 
		query.append("        @[trans_mode] AS CHN_MF_SND_IND_CD," ).append("\n"); 
		query.append("        DECODE(@[trans_mode],'D',BL.BKG_POD_CD,BL.BKG_POL_CD) AS LOC_CD," ).append("\n"); 
		query.append("		BL.BKG_POD_CD," ).append("\n"); 
		query.append("		BL.BKG_POL_CD," ).append("\n"); 
		query.append("        NVL(TO_CHAR(VVD.ETA_DT,'YYYY-MM-DD HH24:MI'),' ') AS ETA," ).append("\n"); 
		query.append("        NVL(TO_CHAR(VVD.ETB_DT,'YYYY-MM-DD HH24:MI'),' ') AS ETB," ).append("\n"); 
		query.append("        NVL(TO_CHAR(VVD.ETD_DT,'YYYY-MM-DD HH24:MI'),' ') AS ETD" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_CHN_BL BL," ).append("\n"); 
		query.append("        BKG_CSTMS_CHN_MK MK," ).append("\n"); 
		query.append("        BKG_CSTMS_CHN_RF RF," ).append("\n"); 
		query.append("        MDM_VSL_CNTR VSL," ).append("\n"); 
		query.append("        BKG_BL_MK_DESC MKD," ).append("\n"); 
		query.append("        (SELECT TMP.BL_NO," ).append("\n"); 
		query.append("                TMP.MF_SND_DT," ).append("\n"); 
		query.append("                TMP.TRSM_MSG_TP_ID" ).append("\n"); 
		query.append("         FROM   (SELECT SLB.BL_NO," ).append("\n"); 
		query.append("                        SL.MF_SND_DT," ).append("\n"); 
		query.append("                        SL.TRSM_MSG_TP_ID" ).append("\n"); 
		query.append("                 FROM   BKG_CSTMS_CHN_SND_LOG SL," ).append("\n"); 
		query.append("                        BKG_CSTMS_CHN_SND_LOG_BL SLB" ).append("\n"); 
		query.append("                 WHERE  SL.EDI_REF_ID = SLB.EDI_REF_ID" ).append("\n"); 
		query.append("                 AND    SL.CHN_MF_SND_IND_CD = @[trans_mode]" ).append("\n"); 
		query.append("                 AND    SLB.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                 ORDER BY SL.MF_SND_DT DESC ) TMP" ).append("\n"); 
		query.append("         WHERE ROWNUM = 1 ) RK," ).append("\n"); 
		query.append("        BKG_CSTMS_CHN_VVD VVD" ).append("\n"); 
		query.append("WHERE   BL.BL_NO                =    @[bl_no]" ).append("\n"); 
		query.append("AND     BL.CHN_MF_SND_IND_CD    =    @[trans_mode]" ).append("\n"); 
		query.append("AND     BL.BL_NO                =    MK.BL_NO(+)" ).append("\n"); 
		query.append("AND     BL.CHN_MF_SND_IND_CD    =    MK.CHN_MF_SND_IND_CD(+)" ).append("\n"); 
		query.append("AND     MK.CHN_BL_CLSS_CD(+)    =    '1'" ).append("\n"); 
		query.append("AND     BL.BL_NO                =    RF.BL_NO(+)" ).append("\n"); 
		query.append("AND     BL.CHN_MF_SND_IND_CD    =    RF.CHN_MF_SND_IND_CD(+)" ).append("\n"); 
		query.append("AND		RF.RF_SEQ_NO(+)			= 	 '1'" ).append("\n"); 
		query.append("AND     BL.BKG_NO               =    MKD.BKG_NO(+)" ).append("\n"); 
		query.append("AND     BL.VSL_CD               =    VSL.VSL_CD" ).append("\n"); 
		query.append("AND     BL.BL_NO                =    RK.BL_NO(+)" ).append("\n"); 
		query.append("AND     BL.VSL_CD               =    VVD.VSL_CD(+)" ).append("\n"); 
		query.append("AND     BL.SKD_VOY_NO           =    VVD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND     BL.SKD_DIR_CD           =    VVD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND     BL.BKG_POL_CD           =    VVD.PORT_CD(+)" ).append("\n"); 
		query.append("AND     BL.CHN_MF_SND_IND_CD    =    VVD.CHN_MF_SND_IND_CD(+)" ).append("\n"); 
		query.append("AND     ROWNUM                  =    1" ).append("\n"); 

	}
}