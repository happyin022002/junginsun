/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AusCustomsTransmissionDBDAOsearchItemInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AusCustomsTransmissionDBDAOsearchItemInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 호주 위험물 세관 플랫파일 전송시 ItemInfo 조회
	  * </pre>
	  */
	public AusCustomsTransmissionDBDAOsearchItemInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.integration").append("\n"); 
		query.append("FileName : AusCustomsTransmissionDBDAOsearchItemInfoRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("     ''                         CONSOL_NO" ).append("\n"); 
		query.append("    ,A.BL_NO                    SHIPPING_REF" ).append("\n"); 
		query.append("    ,A.POL_CD                   POL_CD" ).append("\n"); 
		query.append("    ,A.POD_CD                   POD_CD  " ).append("\n"); 
		query.append("    ,''                         ITEM_NO    " ).append("\n"); 
		query.append("    ,A.OUT_IMDG_PCK_QTY1        OUTPKG_QTY" ).append("\n"); 
		query.append("    ,A.OUT_IMDG_PCK_CD1         OUTPKG_TP_ID" ).append("\n"); 
		query.append("    ,SUBSTR(A.OUTR_PCK_DESC, 1 , 35 )  OUTPKG_TP    " ).append("\n"); 
		query.append("    ,A.IN_IMDG_PCK_QTY1         INPKG_QTY" ).append("\n"); 
		query.append("    ,SUBSTR(A.INR_PCK_DESC, 1, 35 )	   INPKG_TP" ).append("\n"); 
		query.append("    ,'2'                        STOR_AGE" ).append("\n"); 
		query.append("    ,SUBSTR(REPLACE(REPLACE(B.CUST_NM, CHR(13)||CHR(10),' '),CHR(10)||CHR(13),' '), 1 , 70)  PARTY1" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    ,NVL(NVL(C.EMER_CNTC_PSON_NM,(SELECT EMER_CNTC_PSON_NM FROM BKG_DG_CGO WHERE BKG_NO = A.BL_NO AND CNTR_NO = A.CNTR_NO AND ROWNUM = 1)),'N/A')        PARTY2" ).append("\n"); 
		query.append("    ,NVL(NVL(C.EMER_CNTC_PHN_NO_CTNT,(SELECT EMER_CNTC_PHN_NO_CTNT FROM BKG_DG_CGO WHERE BKG_NO = A.BL_NO AND CNTR_NO = A.CNTR_NO AND ROWNUM = 1)),'N/A')    PARTY3" ).append("\n"); 
		query.append("    ,NVL(NVL(C.EMER_CNTC_PHN_NO_CTNT,(SELECT EMER_CNTC_PHN_NO_CTNT FROM BKG_DG_CGO WHERE BKG_NO = A.BL_NO AND CNTR_NO = A.CNTR_NO AND ROWNUM = 1)),'N/A')    PARTY4" ).append("\n"); 
		query.append("    ,''                         PARTY5" ).append("\n"); 
		query.append("    ,'IMD'                         DG_CD" ).append("\n"); 
		query.append("    ,A.IMDG_CLSS_CD             IMDG_CLASS" ).append("\n"); 
		query.append("    ,A.IMDG_UN_NO               UN_NO" ).append("\n"); 
		query.append("    ,A.FLSH_PNT_CDO_TEMP        FLASH" ).append("\n"); 
		query.append("    ,'CEL'                      FLASH_UNIT" ).append("\n"); 
		query.append("    ,A.IMDG_PCK_GRP_CD          PKG_GROUP" ).append("\n"); 
		query.append("    ,REPLACE(REPLACE(A.EMS_NO,',',''),' ','')  EMS_NO" ).append("\n"); 
		query.append("    ,A.MFAG_NO                  MFAG" ).append("\n"); 
		query.append("    ,A.PRP_SHP_NM               SHIPPING_NAME" ).append("\n"); 
		query.append("    ,'KGM'                      NETWGT_UNIT" ).append("\n"); 
		query.append("    ,A.NET_WGT                  NETWGT" ).append("\n"); 
		query.append("    ,'KGM'                      GROSSWGT_UNIT" ).append("\n"); 
		query.append("    ,A.GRS_WGT                  GROSSWGT" ).append("\n"); 
		query.append("    ,'KGM'                      NEQWGT_UNIT" ).append("\n"); 
		query.append("    ,A.NET_WGT                  NEQWGT" ).append("\n"); 
		query.append("    ,A.CNTR_NO                  CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM BKG_CSTMS_DG A, BKG_CUSTOMER B, BKG_DG_CGO C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.BL_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("AND A.CNTR_NO = C.CNTR_NO(+)" ).append("\n"); 
		query.append("AND A.CNTR_CGO_SEQ = C.CNTR_CGO_SEQ(+)" ).append("\n"); 
		query.append("AND A.BL_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND   A.DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("AND   A.VSL_CD          = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("AND   A.SKD_VOY_NO      = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND   A.SKD_DIR_CD      = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("AND   A.PORT_CD         = @[port_cd]" ).append("\n"); 
		query.append("AND   A.BL_NO           = @[bl_no]" ).append("\n"); 
		query.append("AND	  A.CNT_CD ='AU'" ).append("\n"); 
		query.append("AND   B.BKG_CUST_TP_CD ='C'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY A.CNTR_NO, A.CNTR_CGO_SEQ" ).append("\n"); 

	}
}