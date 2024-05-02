/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : Eur24CustomsTransmissionDBDAOSearchBlCMinfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.05
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.06.05 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24CustomsTransmissionDBDAOSearchBlCMinfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24CustomsTransmissionDBDAOSearchBlCMinfoRSQL
	  * </pre>
	  */
	public Eur24CustomsTransmissionDBDAOSearchBlCMinfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cstms_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration").append("\n"); 
		query.append("FileName : Eur24CustomsTransmissionDBDAOSearchBlCMinfoRSQL").append("\n"); 
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
		query.append("/* Eur24BlCMinfoListVOs Eur24CustomsTransmissionDBDAOSearchBlCMinfo ( String blNo , String vslCd , String skdVoyNo , String skdDirCd , String cstmsPortCd) */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cnt_cd} == 'NL' && ${msg_id_cd} == 'ENSAMD') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT * FROM (" ).append("\n"); 
		query.append("SELECT DECODE(X.GOODS_ITEM_NO_X,NULL,'D',DECODE(Y.MF_ITM_NO,NULL,'A'," ).append("\n"); 
		query.append("					CASE WHEN" ).append("\n"); 
		query.append("                        NVL(X.CNTR_MF_MK_DESC,'X') = NVL(Y.CNTR_MF_MK_DESC,'X')" ).append("\n"); 
		query.append("                    AND NVL(X.CNTR_MF_GDS_DESC,'X')= NVL(Y.CNTR_MF_GDS_DESC,'X')" ).append("\n"); 
		query.append("                    AND NVL(X.PCK_QTY, 0) = NVL(Y.PCK_QTY,0)" ).append("\n"); 
		query.append("                    AND NVL(X.PCK_TP_CD,'X') = NVL(Y.PCK_TP_CD,'X')" ).append("\n"); 
		query.append("                    AND NVL(X.CNTR_MF_WGT,0) = NVL(Y.CNTR_MF_WGT,0)" ).append("\n"); 
		query.append("                    AND NVL(X.WGT_UT_CD,'X') = NVL(Y.WGT_UT_CD,'X')" ).append("\n"); 
		query.append("                    AND NVL(X.MEAS_QTY,0) = NVL(Y.MEAS_QTY,0)" ).append("\n"); 
		query.append("                    AND NVL(X.MEAS_UT_CD,'X') = NVL(Y.MEAS_UT_CD,'X')" ).append("\n"); 
		query.append("                    AND NVL(X.CMDT_HS_CD,'X') = NVL(Y.CMDT_HS_CD,'X')" ).append("\n"); 
		query.append("                    THEN 'U'  -- 임시로 Update 로 보내기로함. NL 세관측 수정후에  History 와 비교하여 변경없을시 ''." ).append("\n"); 
		query.append("                    ELSE 'U'" ).append("\n"); 
		query.append("                    END  ) ) AS CM_FLAG" ).append("\n"); 
		query.append(", NVL(MF_ITM_NO, GOODS_ITEM_NO_X  ) GOODS_ITEM_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", X.PIECE_COUNT                     AS PIECE_COUNT /* 136 */" ).append("\n"); 
		query.append(", DECODE(X.VSL_CD,NULL,Y.PCK_QTY,X.PKG_COUNT)        AS PKG_COUNT /* 137 */" ).append("\n"); 
		query.append(", DECODE(X.VSL_CD,NULL,NVL((SELECT CSTMS_PCK_TP_CD" ).append("\n"); 
		query.append("                          FROM BKG_CSTMS_PCK_TP_CONV" ).append("\n"); 
		query.append("                         WHERE CNT_CD ='EU'" ).append("\n"); 
		query.append("                           AND RCVR_ID = 'ENS'" ).append("\n"); 
		query.append("                           AND PCK_TP_CD = Y.PCK_TP_CD),Y.PCK_TP_CD),X.PKG_TYPE) AS PKG_TYPE /* 138 */" ).append("\n"); 
		query.append("                           " ).append("\n"); 
		query.append(", DECODE(X.VSL_CD,NULL,BKG_SPCLCHAR_CONV_FNC(Y.CNTR_MF_GDS_DESC,'X'), X.GOODS_DESC) AS GOODS_DESC  /* 139 */     " ).append("\n"); 
		query.append(", DECODE(X.VSL_CD,NULL,Y.CNTR_MF_WGT,X.ITEM_GROSS_WGT)     AS ITEM_GROSS_WGT /* 140 */" ).append("\n"); 
		query.append(", DECODE(X.VSL_CD,NULL,Y.CMDT_HS_CD,X.TARIFF_CD)           AS TARIFF_CD      /* 141 */" ).append("\n"); 
		query.append(", X.UNDG_NO                     AS UNDG_NO        /* 142 차후 수정 */" ).append("\n"); 
		query.append(", X.HANDLE_CD                   AS HANDLE_CD      /* 143 */" ).append("\n"); 
		query.append(", X.HANDLE_INFO                 AS HANDLE_INFO    /* 144 */" ).append("\n"); 
		query.append(", DECODE(X.VSL_CD,NULL,Y.CNTR_NO,X.CM_CNTR_NO)     AS CM_CNTR_NO     /* 146 */" ).append("\n"); 
		query.append(", DECODE(X.VSL_CD,NULL,Y.PCK_QTY,X.CM_CNTR_PKG)    AS CM_CNTR_PKG    /* 147 */" ).append("\n"); 
		query.append(", DECODE(X.VSL_CD,NULL,BKG_SPCLCHAR_CONV_FNC(Y.CNTR_MF_MK_DESC,'X'),X.CM_SHIP_MARK) AS CM_SHIP_MARK   /* 148 */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("#if (${cnt_cd} == 'NL' && ${msg_id_cd} == 'ENSAMD') " ).append("\n"); 
		query.append("   ROW_NUMBER() OVER (ORDER BY CNTR_NO,CNTR_CGO_SEQ)    AS GOODS_ITEM_NO_X  /* 135 */" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("   ROW_NUMBER() OVER (ORDER BY CNTR_NO,CNTR_CGO_SEQ)    AS GOODS_ITEM_NO  /* 135 */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cnt_cd} != 'NL' || ${msg_id_cd} != 'ENSAMD') " ).append("\n"); 
		query.append("	, 'A' AS CM_FLAG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  , ''              AS PIECE_COUNT /* 136 */" ).append("\n"); 
		query.append("  , X.PCK_QTY       AS PKG_COUNT /* 137 */" ).append("\n"); 
		query.append("  , NVL((SELECT CSTMS_PCK_TP_CD" ).append("\n"); 
		query.append("	   FROM BKG_CSTMS_PCK_TP_CONV" ).append("\n"); 
		query.append("	  WHERE CNT_CD ='EU'" ).append("\n"); 
		query.append("       AND RCVR_ID = 'ENS'" ).append("\n"); 
		query.append("       AND PCK_TP_CD = X.PCK_TP_CD),X.PCK_TP_CD)     AS PKG_TYPE  /* 138 */" ).append("\n"); 
		query.append("  , BKG_SPCLCHAR_CONV_FNC(X.CNTR_MF_GDS_DESC,'X') AS GOODS_DESC  /* 139 */" ).append("\n"); 
		query.append("  , CNTR_MF_WGT     AS ITEM_GROSS_WGT /* 140 */" ).append("\n"); 
		query.append("  , CMDT_HS_CD      AS TARIFF_CD      /* 141 */" ).append("\n"); 
		query.append("  , (SELECT IMDG_UN_NO" ).append("\n"); 
		query.append("        FROM   BKG_CSTMS_EUR_DG_CGO" ).append("\n"); 
		query.append("        WHERE  VSL_CD        = X.VSL_CD" ).append("\n"); 
		query.append("        AND    SKD_VOY_NO    = X.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND    SKD_DIR_CD    = X.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND    CSTMS_PORT_CD = X.CSTMS_PORT_CD" ).append("\n"); 
		query.append("        AND    BL_NO         = X.BL_NO        " ).append("\n"); 
		query.append("        AND    CNTR_NO       = X.CNTR_NO" ).append("\n"); 
		query.append("        AND    DCGO_SEQ      = NVL(X.DCGO_SEQ,DCGO_SEQ)" ).append("\n"); 
		query.append("        AND    ROWNUM=1" ).append("\n"); 
		query.append("    )               AS UNDG_NO        /* 142 */" ).append("\n"); 
		query.append("  , ''              AS HANDLE_CD      /* 143 */" ).append("\n"); 
		query.append("  , ''              AS HANDLE_INFO    /* 144 */" ).append("\n"); 
		query.append("  , X.CNTR_NO       AS CM_CNTR_NO     /* 146 */" ).append("\n"); 
		query.append("  , X.PCK_QTY       AS CM_CNTR_PKG    /* 147 */" ).append("\n"); 
		query.append("  , BKG_SPCLCHAR_CONV_FNC(CNTR_MF_MK_DESC,'X') AS CM_SHIP_MARK   /* 148 */" ).append("\n"); 
		query.append("  , VSL_CD,      SKD_VOY_NO,       SKD_DIR_CD,       BL_NO,     CSTMS_PORT_CD, CNTR_NO, CNTR_CGO_SEQ" ).append("\n"); 
		query.append("  , PCK_QTY,     CNTR_MF_MK_DESC,  CNTR_MF_GDS_DESC, PCK_TP_CD,  MEAS_QTY" ).append("\n"); 
		query.append("  , CNTR_MF_WGT  ,WGT_UT_CD         ,MEAS_UT_CD      ,CMDT_HS_CD  ,DCGO_SEQ " ).append("\n"); 
		query.append("  , CRE_USR_ID,  CRE_DT,           UPD_USR_ID,       UPD_DT" ).append("\n"); 
		query.append("FROM BKG_CSTMS_EUR_CNTR_MF  X  " ).append("\n"); 
		query.append("WHERE VSL_CD   = @[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND BL_NO      = @[bl_no]" ).append("\n"); 
		query.append("AND CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("AND EXISTS ( SELECT 'X' FROM BKG_CSTMS_EUR_CNTR C" ).append("\n"); 
		query.append("             WHERE C.VSL_cD = X.VSL_CD" ).append("\n"); 
		query.append("             AND C.SKD_VOY_NO = X.SKD_VOY_NO" ).append("\n"); 
		query.append("             AND C.SKD_DIR_CD = X.SKD_dIR_CD" ).append("\n"); 
		query.append("             AND C.CSTMS_PORT_CD = X.CSTMS_PORT_CD" ).append("\n"); 
		query.append("             AND C.BL_NO = X.BL_NO" ).append("\n"); 
		query.append("             AND C.CNTR_NO = X.CNTR_NO)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cnt_cd} == 'NL' && ${msg_id_cd} == 'ENSAMD') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") X " ).append("\n"); 
		query.append("FULL OUTER JOIN " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("SELECT  *  " ).append("\n"); 
		query.append("  FROM BKG_CSTMS_EUR_CNTR_MF_SND " ).append("\n"); 
		query.append("WHERE BL_NO      = @[bl_no]" ).append("\n"); 
		query.append("AND CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("AND EDI_SND_SEQ = (SELECT MAX(EDI_SND_SEQ)" ).append("\n"); 
		query.append("                      FROM BKG_CSTMS_EUR_CNTR_MF_SND" ).append("\n"); 
		query.append("					 WHERE BL_NO      = @[bl_no]" ).append("\n"); 
		query.append("					   AND CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("				      )" ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append(") Y ON ( X.GOODS_ITEM_NO_X = Y.MF_ITM_NO )" ).append("\n"); 
		query.append(") WHERE CM_FLAG IS NOT NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}