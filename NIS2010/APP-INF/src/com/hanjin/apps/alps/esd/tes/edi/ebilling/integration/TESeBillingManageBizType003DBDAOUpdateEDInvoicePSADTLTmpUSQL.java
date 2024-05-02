/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TESeBillingManageBizType003DBDAOUpdateEDInvoicePSADTLTmpUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.03
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.edi.ebilling.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESeBillingManageBizType003DBDAOUpdateEDInvoicePSADTLTmpUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSA DTL 후속 작업 : COST CODE MAPPING/YARD MAPPING/COST CODE로 INV유형 결정/VVD MAPPING 등
	  * </pre>
	  */
	public TESeBillingManageBizType003DBDAOUpdateEDInvoicePSADTLTmpUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_inv_edi_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("psa_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.edi.ebilling.integration ").append("\n"); 
		query.append("FileName : TESeBillingManageBizType003DBDAOUpdateEDInvoicePSADTLTmpUSQL").append("\n"); 
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
		query.append("UPDATE TES_EDI_SO_PSA_DTL D" ).append("\n"); 
		query.append("SET  D.LGS_COST_CD          = ( SELECT DISTINCT C.LGS_COST_CD" ).append("\n"); 
		query.append("FROM TES_EDI_SO_COST C" ).append("\n"); 
		query.append("WHERE C.VNDR_SEQ = @[psa_vndr_seq]" ).append("\n"); 
		query.append("AND NVL(TRIM(C.PSA_CHG_CATE_CD),'X') = NVL(TRIM(D.PSA_CHG_CATE_CD),'X')" ).append("\n"); 
		query.append("AND NVL(TRIM(C.PSA_CHG_CLSS_N1ST_CD),'X') = NVL(TRIM(D.PSA_CHG_CLSS_N1ST_CD),'X')" ).append("\n"); 
		query.append("AND NVL(TRIM(C.PSA_CHG_CLSS_N2ND_CD),'X') = NVL(TRIM(D.PSA_CHG_CLSS_N2ND_CD),'X')" ).append("\n"); 
		query.append("AND NVL(TRIM(C.PSA_CHG_TP_CD),'X') = NVL(TRIM(D.PSA_CHG_TP_CD),'X')" ).append("\n"); 
		query.append("AND ROWNUM = 1 )," ).append("\n"); 
		query.append("D.YD_CD                = ( SELECT DISTINCT C.YD_CD" ).append("\n"); 
		query.append("FROM TES_EDI_SO_COST C" ).append("\n"); 
		query.append("WHERE C.VNDR_SEQ = @[psa_vndr_seq]" ).append("\n"); 
		query.append("AND NVL(TRIM(C.PSA_CHG_CATE_CD),'X') = NVL(TRIM(D.PSA_CHG_CATE_CD),'X')" ).append("\n"); 
		query.append("AND NVL(TRIM(C.PSA_CHG_CLSS_N1ST_CD),'X') = NVL(TRIM(D.PSA_CHG_CLSS_N1ST_CD),'X')" ).append("\n"); 
		query.append("AND NVL(TRIM(C.PSA_CHG_CLSS_N2ND_CD),'X') = NVL(TRIM(D.PSA_CHG_CLSS_N2ND_CD),'X')" ).append("\n"); 
		query.append("AND NVL(TRIM(C.PSA_CHG_TP_CD),'X') = NVL(TRIM(D.PSA_CHG_TP_CD),'X')" ).append("\n"); 
		query.append("AND ROWNUM = 1 )," ).append("\n"); 
		query.append("D.TML_INV_TP_CD        = ( SELECT" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN NVL(T.MRN_TML_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("THEN 'TM'" ).append("\n"); 
		query.append("WHEN NVL(T.STO_INV_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("THEN 'ST'" ).append("\n"); 
		query.append("WHEN NVL(T.FDCK_CY_TML_FLG,'N') = 'Y' OR NVL(T.FDCK_CY_STO_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("THEN 'OF'" ).append("\n"); 
		query.append("WHEN NVL(T.ODCK_RAIL_CHG_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("THEN 'ON'" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END TML_INV_TP_CD" ).append("\n"); 
		query.append("FROM TES_EDI_SO_COST C, TES_TML_SO_COST T" ).append("\n"); 
		query.append("WHERE C.LGS_COST_CD = T.LGS_COST_CD" ).append("\n"); 
		query.append("AND C.VNDR_SEQ = @[psa_vndr_seq]" ).append("\n"); 
		query.append("AND C.VNDR_TRF_DESC = D.TRF_DESC" ).append("\n"); 
		query.append("AND ROWNUM = 1  )," ).append("\n"); 
		query.append("D.OB_VVD_CD            = ( SELECT B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD" ).append("\n"); 
		query.append("FROM BKG_CSTMS_PSA_VVD B" ).append("\n"); 
		query.append("WHERE B.PSA_VSL_NM = D.PSA_VSL_NM" ).append("\n"); 
		query.append("AND B.PSA_VOY_DIR_CD = D.OB_PSA_VOY_DIR_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1 )," ).append("\n"); 
		query.append("D.IB_VVD_CD            = ( SELECT B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD" ).append("\n"); 
		query.append("FROM BKG_CSTMS_PSA_VVD B" ).append("\n"); 
		query.append("WHERE B.PSA_VSL_NM = D.PSA_VSL_NM" ).append("\n"); 
		query.append("AND B.PSA_VOY_DIR_CD = D.IB_PSA_VOY_DIR_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1 )" ).append("\n"); 
		query.append("WHERE D.TML_EDI_SO_PSA_DTL_SEQ > 0" ).append("\n"); 
		query.append("AND D.TRF_DESC <> 'GST'" ).append("\n"); 
		query.append("AND D.TML_INV_EDI_SEQ = @[tml_inv_edi_seq]" ).append("\n"); 

	}
}