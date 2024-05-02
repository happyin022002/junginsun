/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchChargeInfoByContainerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchChargeInfoByContainerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Charge Info By Container
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchChargeInfoByContainerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchChargeInfoByContainerRSQL").append("\n"); 
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
		query.append("#if (${rev_tp_cd} != 'M')" ).append("\n"); 
		query.append("    #if (${inv_delt_div_cd} == 'N')" ).append("\n"); 
		query.append("        SELECT ROW_NUMBER() OVER(ORDER BY CHG_CD, CURR_CD, PER_TP_CD, CNTR_NO) CHG_SEQ" ).append("\n"); 
		query.append("             , CNTR_NO" ).append("\n"); 
		query.append("             , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("             , CHG_CD" ).append("\n"); 
		query.append("             , CURR_CD" ).append("\n"); 
		query.append("             , PER_TP_CD" ).append("\n"); 
		query.append("             , TRF_RT_AMT" ).append("\n"); 
		query.append("             , RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("             , CHG_AMT" ).append("\n"); 
		query.append("             , '' CHG_REF_NO" ).append("\n"); 
		query.append("			 , @[edi_hdr_seq] EDI_HDR_SEQ" ).append("\n"); 
		query.append("			 , @[cre_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("			 , @[upd_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("			 , NVL((SELECT 'Y'" ).append("\n"); 
		query.append("                	FROM   SCO_LU_HDR H,  SCO_LU_DTL D" ).append("\n"); 
		query.append("                	WHERE  H.LU_TP_CD = D.LU_TP_CD" ).append("\n"); 
		query.append("                	AND    H.LU_APPL_CD = 'SAR'" ).append("\n"); 
		query.append("                	AND    D.LU_TP_CD = 'APC VAT CHARGE'" ).append("\n"); 
		query.append("					AND    D.LU_CD = CHG_CD" ).append("\n"); 
		query.append("                	AND    D.ENBL_FLG = 'Y'), 'N') TVA_FLG" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("                SELECT A.CNTR_NO" ).append("\n"); 
		query.append("                     , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                     , A.CHG_CD" ).append("\n"); 
		query.append("                     , A.CURR_CD" ).append("\n"); 
		query.append("                     , A.RAT_UT_CD PER_TP_CD" ).append("\n"); 
		query.append("                     , A.CHG_UT_AMT TRF_RT_AMT" ).append("\n"); 
		query.append("                     , A.RAT_AS_QTY RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("                     , A.CHG_AMT" ).append("\n"); 
		query.append("                FROM BKG_CNTR_RT A," ).append("\n"); 
		query.append("                     BKG_RATE B," ).append("\n"); 
		query.append("                     MDM_ORGANIZATION C," ).append("\n"); 
		query.append("                     (SELECT DISTINCT CHG_CD, CURR_CD, PER_TP_CD" ).append("\n"); 
		query.append("                      FROM INV_AR_CHG" ).append("\n"); 
		query.append("                      WHERE AR_IF_NO = @[ar_if_no]) D" ).append("\n"); 
		query.append("                WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                AND A.FRT_TERM_CD = DECODE(@[io_bnd_cd],'O','P','C')" ).append("\n"); 
		query.append("                AND NVL(A.N3PTY_RCV_OFC_CD, DECODE(@[io_bnd_cd],'O',B.PPD_RCV_OFC_CD,B.CLT_OFC_CD)) = C.OFC_CD" ).append("\n"); 
		query.append("                AND C.AR_OFC_CD = 'BUEBA'" ).append("\n"); 
		query.append("                AND A.RAT_UT_CD NOT IN ('BL','PC')" ).append("\n"); 
		query.append("				AND D.CHG_CD = A.CHG_CD" ).append("\n"); 
		query.append("                AND D.CURR_CD = A.CURR_CD" ).append("\n"); 
		query.append("                AND D.PER_TP_CD = A.RAT_UT_CD" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT '' CNTR_NO" ).append("\n"); 
		query.append("                     , '' CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                     , CHG_CD" ).append("\n"); 
		query.append("                     , CURR_CD" ).append("\n"); 
		query.append("                     , PER_TP_CD" ).append("\n"); 
		query.append("                     , TRF_RT_AMT" ).append("\n"); 
		query.append("                     , RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("                     , CHG_AMT" ).append("\n"); 
		query.append("                FROM INV_AR_CHG" ).append("\n"); 
		query.append("                WHERE AR_IF_NO = @[ar_if_no]" ).append("\n"); 
		query.append("                AND PER_TP_CD IN ('BL','PC')" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        WHERE CHG_AMT <> 0" ).append("\n"); 
		query.append("        ORDER BY CHG_CD, CURR_CD, PER_TP_CD, CNTR_NO" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("        SELECT A.CHG_SEQ" ).append("\n"); 
		query.append("             , A.CNTR_NO" ).append("\n"); 
		query.append("             , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("             , A.CHG_CD" ).append("\n"); 
		query.append("             , A.CURR_CD" ).append("\n"); 
		query.append("             , A.PER_TP_CD" ).append("\n"); 
		query.append("             , A.TRF_RT_AMT" ).append("\n"); 
		query.append("             , A.RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("             , A.CHG_AMT * (-1) CHG_AMT" ).append("\n"); 
		query.append("             , A.CHG_REF_NO" ).append("\n"); 
		query.append("			 , @[edi_hdr_seq] EDI_HDR_SEQ" ).append("\n"); 
		query.append("			 , @[cre_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("			 , @[upd_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("			 , NVL((SELECT 'Y'" ).append("\n"); 
		query.append("                	FROM   SCO_LU_HDR H,  SCO_LU_DTL D" ).append("\n"); 
		query.append("                	WHERE  H.LU_TP_CD = D.LU_TP_CD" ).append("\n"); 
		query.append("                	AND    H.LU_APPL_CD = 'SAR'" ).append("\n"); 
		query.append("                	AND    D.LU_TP_CD = 'APC VAT CHARGE'" ).append("\n"); 
		query.append("					AND    D.LU_CD = A.CHG_CD" ).append("\n"); 
		query.append("                	AND    D.ENBL_FLG = 'Y'), 'N') TVA_FLG" ).append("\n"); 
		query.append("        FROM INV_EDI_CHG A," ).append("\n"); 
		query.append("             INV_EDI_HDR B" ).append("\n"); 
		query.append("        WHERE A.EDI_HDR_SEQ = B.EDI_HDR_SEQ " ).append("\n"); 
		query.append("        AND B.AR_IF_NO IN (SELECT MAX(AR_IF_NO)" ).append("\n"); 
		query.append("                           FROM INV_AR_MN" ).append("\n"); 
		query.append("                           WHERE BL_SRC_NO = @[bl_no]" ).append("\n"); 
		query.append("                           AND AR_OFC_CD = 'BUEBA'" ).append("\n"); 
		query.append("                           AND REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("                           AND NVL(INV_SPLIT_CD, 'M') IN ('M','C','E','X')  " ).append("\n"); 
		query.append("                           AND BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("                           AND INV_DELT_DIV_CD = 'N' " ).append("\n"); 
		query.append("                           AND AR_IF_NO < @[ar_if_no])" ).append("\n"); 
		query.append("        ORDER BY A.CHG_SEQ" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    #if (${rev_tp_src_cd} == 'MDM' || ${rev_tp_src_cd} == 'MDT')" ).append("\n"); 
		query.append("        SELECT B.CHG_SEQ" ).append("\n"); 
		query.append("             , B.TRF_NO CNTR_NO" ).append("\n"); 
		query.append("             , (SELECT CNTR_TPSZ_CD " ).append("\n"); 
		query.append("                FROM INV_AR_IF_CNTR" ).append("\n"); 
		query.append("                WHERE SRC_IF_DT = A.SRC_IF_DT" ).append("\n"); 
		query.append("                AND SRC_IF_SEQ = A.SRC_IF_SEQ" ).append("\n"); 
		query.append("                AND CNTR_NO = B.TRF_NO" ).append("\n"); 
		query.append("                AND ROWNUM = 1) CNTR_TPSZ_CD" ).append("\n"); 
		query.append("             , B.CHG_CD" ).append("\n"); 
		query.append("             , B.CURR_CD" ).append("\n"); 
		query.append("             , B.PER_TP_CD" ).append("\n"); 
		query.append("             , B.TRF_RT_AMT" ).append("\n"); 
		query.append("             , B.RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("             , B.CHG_AMT" ).append("\n"); 
		query.append("             , (SELECT Q.CHG_REF_NO" ).append("\n"); 
		query.append("                FROM INV_EDI_HDR P," ).append("\n"); 
		query.append("                     INV_EDI_CHG Q" ).append("\n"); 
		query.append("                WHERE P.EDI_HDR_SEQ = Q.EDI_HDR_SEQ" ).append("\n"); 
		query.append("                AND P.EDI_TP_CD = 'APC'" ).append("\n"); 
		query.append("                AND P.INV_NO IN (SELECT CR_INV_NO" ).append("\n"); 
		query.append("                                 FROM DMT_INV_MN" ).append("\n"); 
		query.append("                                 WHERE AR_IF_NO = @[ar_if_no]" ).append("\n"); 
		query.append("                                 AND DMDT_INV_NO = @[inv_no]" ).append("\n"); 
		query.append("                                 AND DMDT_AR_IF_CD = 'Y'" ).append("\n"); 
		query.append("                                 AND DMDT_INV_STS_CD = 'C')" ).append("\n"); 
		query.append("                AND Q.CHG_SEQ = B.CHG_SEQ) CHG_REF_NO" ).append("\n"); 
		query.append("             , @[edi_hdr_seq] EDI_HDR_SEQ" ).append("\n"); 
		query.append("             , @[cre_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("             , @[upd_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("             , NVL((SELECT 'Y'" ).append("\n"); 
		query.append("                    FROM   SCO_LU_HDR H,  SCO_LU_DTL D" ).append("\n"); 
		query.append("                    WHERE  H.LU_TP_CD = D.LU_TP_CD" ).append("\n"); 
		query.append("                    AND    H.LU_APPL_CD = 'SAR'" ).append("\n"); 
		query.append("                    AND    D.LU_TP_CD = 'APC VAT CHARGE'" ).append("\n"); 
		query.append("                    AND    D.LU_CD = CHG_CD" ).append("\n"); 
		query.append("                    AND    D.ENBL_FLG = 'Y'), 'N') TVA_FLG" ).append("\n"); 
		query.append("        FROM INV_AR_IF_MN A," ).append("\n"); 
		query.append("             INV_AR_IF_CHG B" ).append("\n"); 
		query.append("        WHERE A.SRC_IF_DT = B.SRC_IF_DT" ).append("\n"); 
		query.append("        AND A.SRC_IF_SEQ = B.SRC_IF_SEQ" ).append("\n"); 
		query.append("        AND A.AR_IF_NO = @[ar_if_no]" ).append("\n"); 
		query.append("        ORDER BY B.CHG_SEQ" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("        SELECT CHG_SEQ" ).append("\n"); 
		query.append("             , '' CNTR_NO" ).append("\n"); 
		query.append("             , '' CNTR_TPSZ_CD" ).append("\n"); 
		query.append("             , CHG_CD" ).append("\n"); 
		query.append("             , CURR_CD" ).append("\n"); 
		query.append("             , PER_TP_CD" ).append("\n"); 
		query.append("             , TRF_RT_AMT" ).append("\n"); 
		query.append("             , RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("             , CHG_AMT" ).append("\n"); 
		query.append("             , '' CHG_REF_NO" ).append("\n"); 
		query.append("             , @[edi_hdr_seq] EDI_HDR_SEQ" ).append("\n"); 
		query.append("             , @[cre_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("             , @[upd_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("             , NVL((SELECT 'Y'" ).append("\n"); 
		query.append("                    FROM   SCO_LU_HDR H,  SCO_LU_DTL D" ).append("\n"); 
		query.append("                    WHERE  H.LU_TP_CD = D.LU_TP_CD" ).append("\n"); 
		query.append("                    AND    H.LU_APPL_CD = 'SAR'" ).append("\n"); 
		query.append("                    AND    D.LU_TP_CD = 'APC VAT CHARGE'" ).append("\n"); 
		query.append("                    AND    D.LU_CD = CHG_CD" ).append("\n"); 
		query.append("                    AND    D.ENBL_FLG = 'Y'), 'N') TVA_FLG" ).append("\n"); 
		query.append("        FROM INV_AR_CHG" ).append("\n"); 
		query.append("        WHERE AR_IF_NO = @[ar_if_no]" ).append("\n"); 
		query.append("        ORDER BY CHG_SEQ" ).append("\n"); 
		query.append("    #end      " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}