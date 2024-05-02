/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DubaiCustomsTransmissionDBDAOsearchFlatFileCntrMfListRSQL.java
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

public class DubaiCustomsTransmissionDBDAOsearchFlatFileCntrMfListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 두바이 FlatFile 컨테이너 mf 정보를 조회한다.
	  * </pre>
	  */
	public DubaiCustomsTransmissionDBDAOsearchFlatFileCntrMfListRSQL(){
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
		query.append("FileName : DubaiCustomsTransmissionDBDAOsearchFlatFileCntrMfListRSQL").append("\n");
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
		query.append("       MF.BL_NO" ).append("\n");
		query.append("      ,MF.CNTR_NO" ).append("\n");
		query.append("      ,MF.CNTR_MF_SEQ" ).append("\n");
		query.append("      ,LPAD(MF.DU_CNTR_SER_NO, 3, '0') AS DU_CNTR_SER_NO" ).append("\n");
		query.append("      ,DECODE(SUBSTR(BL.DU_CNTR_SVC_TP_CD, 2,1), 'L', NVL(SUBSTR(REPLACE(MF.CNTR_MF_MK_DESC, CHR(10), ''),1,200), 'NIL'), 'NIL')" ).append("\n");
		query.append("       AS CNTR_MF_MK_DESC" ).append("\n");
		query.append("      ,SUBSTR(REPLACE(MF.CNTR_MF_GDS_DESC, CHR(10), ''), 1, 100) AS CNTR_MF_GDS_DESC" ).append("\n");
		query.append("      ,MF.CMDT_HS_CD" ).append("\n");
		query.append("      ,MF.PCK_QTY" ).append("\n");
		query.append("      ,SUBSTR(MF.PCK_TP_DESC, 1, 30) AS PCK_TP_DESC" ).append("\n");
		query.append("      ,MF.DU_PCK_TP_CD" ).append("\n");
		query.append("      ,MF.PLT_QTY" ).append("\n");
		query.append("      ,TRIM(TO_CHAR(MF.CNTR_MF_WGT, '000000.0')) AS CNTR_MF_WGT" ).append("\n");
		query.append("      ,TRIM(TO_CHAR(MF.MEAS_QTY, '000000.0')) AS MEAS_QTY" ).append("\n");
		query.append("      ,MF.DCGO_FLG" ).append("\n");
		query.append("      ,MF.IMDG_UN_NO" ).append("\n");
		query.append("      ,MF.IMDG_CLSS_CD" ).append("\n");
		query.append("      ,TRIM(TO_CHAR(NVL(MF.FLSH_PNT_CDO_TEMP,0), '00.0')) AS FLSH_PNT_CDO_TEMP" ).append("\n");
		query.append("      ,MF.DCGO_TEMP_UT_CD" ).append("\n");
		query.append("      ,MF.DG_STO_REQ_FLG" ).append("\n");
		query.append("      ,MF.RFRT_REQ_FLG" ).append("\n");
		query.append("      ,TRIM(TO_CHAR(NVL(MF.MIN_TEMP,0), '00.0')) AS MIN_TEMP" ).append("\n");
		query.append("      ,TRIM(TO_CHAR(NVL(MF.MAX_TEMP,0), '00.0')) AS MAX_TEMP" ).append("\n");
		query.append("      ,MF.CGO_TEMP_UT_CD" ).append("\n");
		query.append("  FROM BKG_CSTMS_DU_CNTR_MF MF" ).append("\n");
		query.append("      ,BKG_CSTMS_DU_BL BL" ).append("\n");
		query.append(" WHERE MF.BL_NO = BL.BL_NO" ).append("\n");
		query.append("   AND MF.POD_CD = BL.POD_CD" ).append("\n");
		query.append("   AND MF.BL_NO = @[bl_no]" ).append("\n");
		query.append("   AND MF.POD_CD = @[pod_cd]" ).append("\n");

	}
}