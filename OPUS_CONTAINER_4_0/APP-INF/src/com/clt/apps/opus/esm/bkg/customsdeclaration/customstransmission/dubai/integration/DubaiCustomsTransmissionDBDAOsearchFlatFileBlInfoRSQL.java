/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DubaiCustomsTransmissionDBDAOsearchFlatFileBlInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.22
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.03.22 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.dubai.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DubaiCustomsTransmissionDBDAOsearchFlatFileBlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * DubaiBlInfoVO
	  * </pre>
	  */
	public DubaiCustomsTransmissionDBDAOsearchFlatFileBlInfoRSQL(){
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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.dubai.integration").append("\n");
		query.append("FileName : DubaiCustomsTransmissionDBDAOsearchFlatFileBlInfoRSQL").append("\n");
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
		query.append("SELECT BL.BL_NO || BKG.BL_TP_CD AS BL_NO" ).append("\n");
		query.append("      ,BL.VSL_CD" ).append("\n");
		query.append("      ,BL.SKD_VOY_NO" ).append("\n");
		query.append("      ,BL.SKD_DIR_CD" ).append("\n");
		query.append("      ,BL.DU_ROTN_NO" ).append("\n");
		query.append("      ,BL.DU_LINE_ID" ).append("\n");
		query.append("      ,BL.DU_VOY_AGN_ID" ).append("\n");
		query.append("      ,BL.ORG_PORT_CD" ).append("\n");
		query.append("      ,BL.POR_CD" ).append("\n");
		query.append("      ,BL.POL_CD" ).append("\n");
		query.append("      ,BL.POD_CD" ).append("\n");
		query.append("      ,BL.DEL_CD" ).append("\n");
		query.append("      ,BL.DU_MF_NO" ).append("\n");
		query.append("      ,BL.DU_CGO_CD" ).append("\n");
		query.append("      ,C.INTG_CD_VAL_DP_DESC AS DU_CNTR_SVC_TP_CD" ).append("\n");
		query.append("      ,BL.DU_TRD_CD" ).append("\n");
		query.append("      ,BL.DU_TS_MOD_CD" ).append("\n");
		query.append("      ,BL.CNSL_CGO_FLG" ).append("\n");
		query.append("      ,BL.ORG_BL_NO" ).append("\n");
		query.append("      ,BL.ORG_CNT_CD" ).append("\n");
		query.append("      ,BL.ORG_VSL_CD" ).append("\n");
		query.append("      ,BL.ORG_SKD_VOY_NO" ).append("\n");
		query.append("      ,BL.ORG_SKD_DIR_CD" ).append("\n");
		query.append("      ,SUBSTR(BL.VSL_NM,1,30) AS ORG_VSL_NM" ).append("\n");
		query.append("      ,DECODE(SUBSTR(BL.DU_CNTR_SVC_TP_CD, 2,1), 'L', NVL(SUBSTR(REPLACE(BL.MK_NO_CTNT, CHR(10), ''),1,200), 'NIL'), 'NIL')" ).append("\n");
		query.append("       AS MK_NO_CTNT" ).append("\n");
		query.append("      ,BL.DU_CMDT_CD" ).append("\n");
		query.append("      ,SUBSTR(REPLACE(BL.CMDT_DESC, CHR(10), ''),1,100) AS CMDT_DESC" ).append("\n");
		query.append("      ,BL.PCK_QTY" ).append("\n");
		query.append("      ,SUBSTR(BL.DU_PCK_DESC, 1, 30) AS DU_PCK_DESC" ).append("\n");
		query.append("      ,BL.DU_PCK_TP_CD" ).append("\n");
		query.append("      ,BL.CNTR_NO" ).append("\n");
		query.append("      ,SUBSTR(BL.CNTR_NO, LENGTH(BL.CNTR_NO), 1) AS CHECK_DIGIT" ).append("\n");
		query.append("      ,LPAD(BL.CNTR_KNT, 2, '0') AS CNTR_KNT" ).append("\n");
		query.append("      ,LPAD(BL.BKG_TEU_QTY, 4, '0') AS BKG_TEU_QTY" ).append("\n");
		query.append("      ,BL.TARE_WGT" ).append("\n");
		query.append("      ,TRIM(TO_CHAR(NVL(BL.CGO_WGT,0), '000000.0')) AS CGO_WGT" ).append("\n");
		query.append("      ,TRIM(TO_CHAR(NVL(BL.GRS_WGT,0), '000000.0')) AS GRS_WGT" ).append("\n");
		query.append("      ,TRIM(TO_CHAR(NVL(BL.MEAS_QTY,0), '000000.0')) AS MEAS_QTY" ).append("\n");
		query.append("      ,NVL(BL.DU_TTL_QTY, 0) AS DU_TTL_QTY" ).append("\n");
		query.append("      ,NVL(BL.DU_FRT_WGT, 0) AS DU_FRT_WGT" ).append("\n");
		query.append("      ,BL.PLT_QTY" ).append("\n");
		query.append("      ,CS.CUST_CNT_CD     AS S_CUST_CNT_CD" ).append("\n");
		query.append("      ,SUBSTR(REPLACE(REPLACE(CS.CUST_NM , CHR(10), ''), CHR(13), ''),1,30)         AS S_CUST_NM" ).append("\n");
		query.append("      ,SUBSTR(REPLACE(REPLACE(CS.CUST_ADDR , CHR(10), ''), CHR(13), ''),1,240)      AS S_CUST_ADDR" ).append("\n");
		query.append("      ,SUBSTR(REPLACE(REPLACE(CS.ORG_CUST_NM , CHR(10), ''), CHR(13), ''),1,30)     AS S_ORG_CUST_NM" ).append("\n");
		query.append("      ,SUBSTR(REPLACE(REPLACE(CS.ORG_CUST_ADDR , CHR(10), ''), CHR(13), ''),1,240)  AS S_ORG_CUST_ADDR" ).append("\n");
		query.append("      ,CC.CUST_CNT_CD     AS C_CUST_CNT_CD" ).append("\n");
		query.append("      ,CC.DU_CUST_ID      AS C_DU_CUST_ID" ).append("\n");
		query.append("      ,SUBSTR(REPLACE(REPLACE(CC.CUST_NM , CHR(10), ''), CHR(13), ''),1,48)         AS C_CUST_NM" ).append("\n");
		query.append("      ,SUBSTR(REPLACE(REPLACE(CC.CUST_ADDR , CHR(10), ''), CHR(13), ''),1,240)      AS C_CUST_ADDR" ).append("\n");
		query.append("      ,SUBSTR(REPLACE(REPLACE(CC.ORG_CUST_NM , CHR(10), ''), CHR(13), ''),1,30)     AS C_ORG_CUST_NM" ).append("\n");
		query.append("      ,SUBSTR(REPLACE(REPLACE(CC.ORG_CUST_ADDR , CHR(10), ''), CHR(13), ''),1,240)  AS C_ORG_CUST_ADDR" ).append("\n");
		query.append("      ,CN.CUST_CNT_CD     AS N_CUST_CNT_CD" ).append("\n");
		query.append("      ,CN.DU_CUST_ID      AS N_DU_CUST_ID" ).append("\n");
		query.append("      ,SUBSTR(REPLACE(REPLACE(CN.CUST_NM , CHR(10), ''), CHR(13), ''),1,48)         AS N_CUST_NM" ).append("\n");
		query.append("      ,SUBSTR(REPLACE(REPLACE(CN.CUST_ADDR , CHR(10), ''), CHR(13), ''),1,240)      AS N_CUST_ADDR" ).append("\n");
		query.append("  FROM BKG_CSTMS_DU_BL BL" ).append("\n");
		query.append("      ,BKG_CSTMS_DU_CUST CS" ).append("\n");
		query.append("      ,BKG_CSTMS_DU_CUST CC" ).append("\n");
		query.append("      ,BKG_CSTMS_DU_CUST CN" ).append("\n");
		query.append("      ,COM_INTG_CD_DTL C" ).append("\n");
		query.append("      ,(" ).append("\n");
		query.append("        SELECT B.BL_NO" ).append("\n");
		query.append("              ,B.BL_TP_CD" ).append("\n");
		query.append("              ,B.RC_FLG" ).append("\n");
		query.append("          FROM BKG_BOOKING B" ).append("\n");
		query.append("         WHERE BL_NO = @[bl_no]" ).append("\n");
		query.append("       ) BKG" ).append("\n");
		query.append(" WHERE BL.BL_NO = @[bl_no]" ).append("\n");
		query.append("   AND BL.POD_CD = @[pod_cd]" ).append("\n");
		query.append("   AND BKG.BL_NO = BL.BL_NO" ).append("\n");
		query.append("   AND BL.BL_NO = CS.BL_NO(+)" ).append("\n");
		query.append("   AND BL.POD_CD = CS.POD_CD(+)" ).append("\n");
		query.append("   AND CS.BKG_CUST_TP_CD(+) = 'S'" ).append("\n");
		query.append("   AND BL.BL_NO = CC.BL_NO(+)" ).append("\n");
		query.append("   AND BL.POD_CD = CC.POD_CD(+)" ).append("\n");
		query.append("   AND CC.BKG_CUST_TP_CD(+) = 'C'" ).append("\n");
		query.append("   AND BL.BL_NO = CN.BL_NO(+)" ).append("\n");
		query.append("   AND BL.POD_CD = CN.POD_CD(+)" ).append("\n");
		query.append("   AND CN.BKG_CUST_TP_CD(+) = 'N'" ).append("\n");
		query.append("   AND BL.DU_CNTR_SVC_TP_CD = C.INTG_CD_VAL_CTNT(+)" ).append("\n");
		query.append("   AND C.INTG_CD_ID(+) = 'CD02560'" ).append("\n");

	}
}