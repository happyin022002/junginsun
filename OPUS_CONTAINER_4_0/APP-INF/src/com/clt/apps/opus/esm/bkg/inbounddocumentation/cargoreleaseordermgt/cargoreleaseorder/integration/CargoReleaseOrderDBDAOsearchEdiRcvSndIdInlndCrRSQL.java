/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchEdiRcvSndIdInlndCrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchEdiRcvSndIdInlndCrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inland setting된 yard에도 보내기 위한 SND ID RCVID 가져옴
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchEdiRcvSndIdInlndCrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_knd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchEdiRcvSndIdInlndCrRSQL").append("\n"); 
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
		query.append("--BKG_EDI_YD 테이블을 BKG_EDI_TRD_PRNR_SUB_LNK, BKG_EDI_SUB_LNK_MSG로 수정" ).append("\n"); 
		query.append("SELECT 'CR' AS EDI_MSG_ID, C.RCVR_TRD_PRNR_ID AS EDI_RCV_ID, C.SNDR_TRD_PRNR_ID AS EDI_SND_ID" ).append("\n"); 
		query.append("  FROM BKG_CGO_RLSE     A," ).append("\n"); 
		query.append("       BKG_BOOKING      B," ).append("\n"); 
		query.append("       BKG_EDI_TRD_PRNR_SUB_LNK C," ).append("\n"); 
		query.append("       BKG_EDI_SUB_LNK_MSG D" ).append("\n"); 
		query.append(" WHERE A.BL_NO       = @[bl_no]" ).append("\n"); 
		query.append("   AND A.BL_NO       = B.BL_NO" ).append("\n"); 
		query.append("   AND C.PRNR_SUB_LNK_CD = ( DECODE(B.DE_TERM_CD,'Y',B.DEL_NOD_CD, " ).append("\n"); 
		query.append("                                                   'D',(SELECT MAX (COPD.NOD_CD) NOD_CD" ).append("\n"); 
		query.append("                                                         FROM SCE_COP_HDR COPM" ).append("\n"); 
		query.append("                                                           , SCE_COP_DTL COPD" ).append("\n"); 
		query.append("                                                           , MDM_ACTIVITY MDM" ).append("\n"); 
		query.append("                                                        WHERE 1=1 " ).append("\n"); 
		query.append("                                                        --AND SUBSTR(BKGM.DEL_CD, 1,2) = 'US'" ).append("\n"); 
		query.append("                                                          AND COPM.BKG_NO = (SELECT BKG_NO " ).append("\n"); 
		query.append("                                                                               FROM BKG_BOOKING " ).append("\n"); 
		query.append("                                                                              WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                                                                                AND ROWNUM = 1)" ).append("\n"); 
		query.append("                                                          AND COPD.COP_NO = COPM.COP_NO" ).append("\n"); 
		query.append("                                                          AND COPM.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("                                                          AND COPD.ACT_CD IN ('FITRDO', 'FITYDO')  " ).append("\n"); 
		query.append("                                                          AND MDM.ACT_CD = COPD.ACT_CD)               ,B.DEL_NOD_CD)) -- CY면 DEL_NOD_CD , DOOR면 [Truck Gate Out from I/B CY] or [Truck Gate Out from I/B Rail Ramp]" ).append("\n"); 
		query.append("   AND D.EDI_MSG_IND_CD = 1" ).append("\n"); 
		query.append("   AND C.TRD_PRNR_SUB_LNK_SEQ = D.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("   AND D.EDI_MSG_TP_ID = 'TDC315'" ).append("\n"); 
		query.append("   AND (D.MSG_TP_DESC = '1' OR D.MSG_TP_DESC = '2')" ).append("\n"); 
		query.append("   AND ROWNUM	= 1" ).append("\n"); 
		query.append("   AND 'CR1'    = @[edi_knd] " ).append("\n"); 
		query.append("UNION   " ).append("\n"); 
		query.append("SELECT 'CR' AS EDI_MSG_ID, C.RCVR_TRD_PRNR_ID AS EDI_RCV_ID, C.SNDR_TRD_PRNR_ID AS EDI_SND_ID" ).append("\n"); 
		query.append("  FROM BKG_CGO_RLSE     A," ).append("\n"); 
		query.append("       BKG_BOOKING      B," ).append("\n"); 
		query.append("       BKG_EDI_TRD_PRNR_SUB_LNK C," ).append("\n"); 
		query.append("       BKG_EDI_SUB_LNK_MSG D" ).append("\n"); 
		query.append(" WHERE A.BL_NO       = @[bl_no]" ).append("\n"); 
		query.append("   AND A.FRT_CLT_FLG  = 'Y'" ).append("\n"); 
		query.append("   AND A.OBL_RDEM_FLG = 'Y'" ).append("\n"); 
		query.append("   AND A.BL_NO       = B.BL_NO" ).append("\n"); 
		query.append("   AND C.PRNR_SUB_LNK_CD = ( DECODE(B.DE_TERM_CD,'Y',B.DEL_NOD_CD, " ).append("\n"); 
		query.append("                                                 'D',(SELECT MAX (COPD.NOD_CD) NOD_CD" ).append("\n"); 
		query.append("                                                        FROM SCE_COP_HDR COPM" ).append("\n"); 
		query.append("                                                           , SCE_COP_DTL COPD" ).append("\n"); 
		query.append("                                                           , MDM_ACTIVITY MDM" ).append("\n"); 
		query.append("                                                        WHERE 1=1 " ).append("\n"); 
		query.append("                                                        --AND SUBSTR(BKGM.DEL_CD, 1,2) = 'US'" ).append("\n"); 
		query.append("                                                          AND COPM.BKG_NO = (SELECT BKG_NO " ).append("\n"); 
		query.append("                                                                               FROM BKG_BOOKING " ).append("\n"); 
		query.append("                                                                              WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                                                                                AND ROWNUM = 1)" ).append("\n"); 
		query.append("                                                          AND COPD.COP_NO = COPM.COP_NO" ).append("\n"); 
		query.append("                                                          AND COPM.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("                                                          AND COPD.ACT_CD IN ('FITRDO', 'FITYDO')  " ).append("\n"); 
		query.append("                                                          AND MDM.ACT_CD = COPD.ACT_CD)               ,B.DEL_NOD_CD)) -- CY면 DEL_NOD_CD , DOOR면 [Truck Gate Out from I/B CY] or [Truck Gate Out from I/B Rail Ramp]" ).append("\n"); 
		query.append("   AND D.EDI_MSG_IND_CD = 1" ).append("\n"); 
		query.append("   AND C.TRD_PRNR_SUB_LNK_SEQ = D.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("   AND D.EDI_MSG_TP_ID = 'TDC315'" ).append("\n"); 
		query.append("   --AND D.MSG_TP_DESC = DECODE(SUBSTR(B.POD_CD,1,2),'CA','2','1')   --20150603 조건에서 뺌 H 로직 추정" ).append("\n"); 
		query.append("   AND ROWNUM	      = 1" ).append("\n"); 
		query.append("   AND 'CR2'    = @[edi_knd] " ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT 'CR' AS EDI_MSG_ID, C.RCVR_TRD_PRNR_ID AS EDI_RCV_ID, C.SNDR_TRD_PRNR_ID AS EDI_SND_ID" ).append("\n"); 
		query.append("  FROM BKG_CGO_RLSE A," ).append("\n"); 
		query.append("       BKG_BOOKING  B," ).append("\n"); 
		query.append("       BKG_EDI_TRD_PRNR_SUB_LNK C," ).append("\n"); 
		query.append("       BKG_EDI_SUB_LNK_MSG D" ).append("\n"); 
		query.append(" WHERE A.BL_NO        = @[bl_no] " ).append("\n"); 
		query.append("   AND A.BL_NO        = B.BL_NO" ).append("\n"); 
		query.append("   AND A.FRT_CLT_FLG  = 'Y'" ).append("\n"); 
		query.append("   AND A.OBL_RDEM_FLG = 'Y'" ).append("\n"); 
		query.append("   AND DECODE(A.CSTMS_CLR_CD,'Y','Y'," ).append("\n"); 
		query.append("                             'T','Y'," ).append("\n"); 
		query.append("                             'E','Y'," ).append("\n"); 
		query.append("                             'I','Y'," ).append("\n"); 
		query.append("                             'W','Y'," ).append("\n"); 
		query.append("                             'P','Y','N') = 'Y'" ).append("\n"); 
		query.append("   AND C.PRNR_SUB_LNK_CD = ( DECODE(B.DE_TERM_CD,'Y',B.DEL_NOD_CD, " ).append("\n"); 
		query.append("                                                   'D',(SELECT MAX (COPD.NOD_CD) NOD_CD" ).append("\n"); 
		query.append("                                                         FROM SCE_COP_HDR COPM" ).append("\n"); 
		query.append("                                                           , SCE_COP_DTL COPD" ).append("\n"); 
		query.append("                                                           , MDM_ACTIVITY MDM" ).append("\n"); 
		query.append("                                                        WHERE 1=1 " ).append("\n"); 
		query.append("                                                        --AND SUBSTR(BKGM.DEL_CD, 1,2) = 'US'" ).append("\n"); 
		query.append("                                                          AND COPM.BKG_NO = (SELECT BKG_NO " ).append("\n"); 
		query.append("                                                                               FROM BKG_BOOKING " ).append("\n"); 
		query.append("                                                                              WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                                                                                AND ROWNUM = 1)" ).append("\n"); 
		query.append("                                                          AND COPD.COP_NO = COPM.COP_NO" ).append("\n"); 
		query.append("                                                          AND COPM.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("                                                          AND COPD.ACT_CD IN ('FITRDO', 'FITYDO')  " ).append("\n"); 
		query.append("                                                          AND MDM.ACT_CD = COPD.ACT_CD)               ,B.DEL_NOD_CD)) -- CY면 DEL_NOD_CD , DOOR면 [Truck Gate Out from I/B CY] or [Truck Gate Out from I/B Rail Ramp]" ).append("\n"); 
		query.append("   AND D.EDI_MSG_IND_CD = 1" ).append("\n"); 
		query.append("   AND C.TRD_PRNR_SUB_LNK_SEQ = D.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("   AND D.EDI_MSG_TP_ID = 'TDC315'" ).append("\n"); 
		query.append("   AND D.MSG_TP_DESC = '2'" ).append("\n"); 
		query.append("   AND ROWNUM	      = 1" ).append("\n"); 
		query.append("   AND 'CR3'    = @[edi_knd] " ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT 'CR' AS EDI_MSG_ID, C.RCVR_TRD_PRNR_ID AS EDI_RCV_ID, C.SNDR_TRD_PRNR_ID AS EDI_SND_ID" ).append("\n"); 
		query.append("  FROM BKG_CGO_RLSE     A," ).append("\n"); 
		query.append("       BKG_BOOKING      B," ).append("\n"); 
		query.append("       BKG_EDI_TRD_PRNR_SUB_LNK C," ).append("\n"); 
		query.append("       BKG_EDI_SUB_LNK_MSG D" ).append("\n"); 
		query.append(" WHERE A.BL_NO       = @[bl_no]" ).append("\n"); 
		query.append("   AND A.BL_NO       = B.BL_NO" ).append("\n"); 
		query.append("   AND C.PRNR_SUB_LNK_CD = ( DECODE(B.DE_TERM_CD,'Y',B.DEL_NOD_CD, " ).append("\n"); 
		query.append("                                                   'D',(SELECT MAX (COPD.NOD_CD) NOD_CD" ).append("\n"); 
		query.append("                                                         FROM SCE_COP_HDR COPM" ).append("\n"); 
		query.append("                                                           , SCE_COP_DTL COPD" ).append("\n"); 
		query.append("                                                           , MDM_ACTIVITY MDM" ).append("\n"); 
		query.append("                                                        WHERE 1=1 " ).append("\n"); 
		query.append("                                                        --AND SUBSTR(BKGM.DEL_CD, 1,2) = 'US'" ).append("\n"); 
		query.append("                                                          AND COPM.BKG_NO = (SELECT BKG_NO " ).append("\n"); 
		query.append("                                                                               FROM BKG_BOOKING " ).append("\n"); 
		query.append("                                                                              WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                                                                                AND ROWNUM = 1)" ).append("\n"); 
		query.append("                                                          AND COPD.COP_NO = COPM.COP_NO" ).append("\n"); 
		query.append("                                                          AND COPM.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("                                                          AND COPD.ACT_CD IN ('FITRDO', 'FITYDO')  " ).append("\n"); 
		query.append("                                                          AND MDM.ACT_CD = COPD.ACT_CD)               ,B.DEL_NOD_CD)) -- CY면 DEL_NOD_CD , DOOR면 [Truck Gate Out from I/B CY] or [Truck Gate Out from I/B Rail Ramp]" ).append("\n"); 
		query.append("   AND D.EDI_MSG_IND_CD = 1" ).append("\n"); 
		query.append("   AND C.TRD_PRNR_SUB_LNK_SEQ = D.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("   AND D.EDI_MSG_TP_ID = 'TDC315'" ).append("\n"); 
		query.append("   AND ROWNUM	          = 1" ).append("\n"); 
		query.append("   AND 'CR4'              = @[edi_knd]" ).append("\n"); 

	}
}