/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : Eur24CustomsTransmissionDBDAOSearchBlCMinfoOBRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.12
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2011.07.12 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24CustomsTransmissionDBDAOSearchBlCMinfoOBRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24CustomsTransmissionDBDAOSearchBlCMinfoOBRSQL
	  * </pre>
	  */
	public Eur24CustomsTransmissionDBDAOSearchBlCMinfoOBRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur24.integration").append("\n"); 
		query.append("FileName : Eur24CustomsTransmissionDBDAOSearchBlCMinfoOBRSQL").append("\n"); 
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
		query.append("/* Eur24BlCMinfoListVOs Eur24CustomsTransmissionDBDAOSearchBlCMinfoOB ( String blNo , String vslCd , String skdVoyNo , String skdDirCd , String cstmsPortCd) */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    ROW_NUMBER() OVER (ORDER BY CNTR_NO,CNTR_CGO_SEQ)    AS GOODS_ITEM_NO  /* 135 */" ).append("\n"); 
		query.append("  , '' AS CM_FLAG" ).append("\n"); 
		query.append("  , ''              AS PIECE_COUNT /* 136 */" ).append("\n"); 
		query.append("  , X.PCK_QTY       AS PKG_COUNT /* 137 */" ).append("\n"); 
		query.append("  , NVL((SELECT CSTMS_PCK_TP_CD" ).append("\n"); 
		query.append("	   FROM BKG_CSTMS_PCK_TP_CONV" ).append("\n"); 
		query.append("	  WHERE CNT_CD ='EU'" ).append("\n"); 
		query.append("       AND PCK_TP_CD = X.PCK_TP_CD),X.PCK_TP_CD)     AS PKG_TYPE  /* 138 */" ).append("\n"); 
		query.append("  , BKG_SPCLCHAR_CONV_FNC(X.CNTR_MF_GDS_DESC,'X') AS GOODS_DESC  /* 139 */" ).append("\n"); 
		query.append("  , CNTR_MF_WGT     AS ITEM_GROSS_WGT /* 140 */" ).append("\n"); 
		query.append("  , CMDT_HS_CD      AS TARIFF_CD      /* 141 */" ).append("\n"); 
		query.append("  , (SELECT IMDG_UN_NO" ).append("\n"); 
		query.append("        FROM   BKG_CSTMS_EUR_IO_DG_CGO" ).append("\n"); 
		query.append("        WHERE  BND_TP_CD = 'O'" ).append("\n"); 
		query.append("	    AND    VSL_CD        = X.VSL_CD" ).append("\n"); 
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
		query.append("FROM BKG_CSTMS_EUR_IO_CNTR_MF  X  " ).append("\n"); 
		query.append("WHERE BND_TP_CD = 'O'" ).append("\n"); 
		query.append("AND VSL_CD   = @[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND BL_NO      = @[bl_no]" ).append("\n"); 
		query.append("AND CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("AND EXISTS ( SELECT 'X' FROM BKG_CSTMS_EUR_IO_CNTR C" ).append("\n"); 
		query.append("             WHERE C.BND_TP_CD = 'O'" ).append("\n"); 
		query.append("             AND C.VSL_CD = X.VSL_CD" ).append("\n"); 
		query.append("             AND C.SKD_VOY_NO = X.SKD_VOY_NO" ).append("\n"); 
		query.append("             AND C.SKD_DIR_CD = X.SKD_dIR_CD" ).append("\n"); 
		query.append("             AND C.CSTMS_PORT_CD = X.CSTMS_PORT_CD" ).append("\n"); 
		query.append("             AND C.BL_NO = X.BL_NO" ).append("\n"); 
		query.append("             AND C.CNTR_NO = X.CNTR_NO)" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}