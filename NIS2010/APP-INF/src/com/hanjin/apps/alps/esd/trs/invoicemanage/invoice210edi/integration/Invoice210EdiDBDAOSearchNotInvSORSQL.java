/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : Invoice210EdiDBDAOSearchNotInvSORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.18
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2015.03.18 DONG- IL, SHIN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoice210edi.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Invoice210EdiDBDAOSearchNotInvSORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchInvCfmSO SELECT
	  * </pre>
	  */
	public Invoice210EdiDBDAOSearchNotInvSORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.invoice210edi.integration").append("\n"); 
		query.append("FileName : Invoice210EdiDBDAOSearchNotInvSORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("      A.TRSP_SO_OFC_CTY_CD      ," ).append("\n"); 
		query.append("      A.TRSP_SO_SEQ             ," ).append("\n"); 
		query.append("      A.TRSP_WO_OFC_CTY_CD      ," ).append("\n"); 
		query.append("      A.TRSP_WO_SEQ             ," ).append("\n"); 
		query.append("      A.EQ_NO                   ," ).append("\n"); 
		query.append("      A.EQ_TPSZ_CD              ," ).append("\n"); 
		query.append("      A.TRSP_SO_TP_CD           ," ).append("\n"); 
		query.append("      A.TRSP_SO_STS_CD          ," ).append("\n"); 
		query.append("      A.TRSP_INV_ACT_STS_CD     ," ).append("\n"); 
		query.append("      A.CURR_CD                 ," ).append("\n"); 
		query.append("      ( NVL(A.BZC_AMT     , 0)" ).append("\n"); 
		query.append("      + NVL(A.NEGO_AMT    , 0)" ).append("\n"); 
		query.append("      + NVL(A.FUEL_SCG_AMT, 0)" ).append("\n"); 
		query.append("	  + NVL(A.SCG_VAT_AMT, 0)" ).append("\n"); 
		query.append("      + NVL(A.TOLL_FEE_AMT, 0)" ).append("\n"); 
		query.append("      + NVL(A.ETC_ADD_AMT , 0)" ).append("\n"); 
		query.append("      ) AS INV_BZC_AMT          ," ).append("\n"); 
		query.append("      A.INV_NO                  ," ).append("\n"); 
		query.append("      A.INV_VNDR_SEQ            ," ).append("\n"); 
		query.append("      A.VNDR_SEQ                ," ).append("\n"); 
		query.append("      A.BZC_AMT                 ," ).append("\n"); 
		query.append("      A.NEGO_AMT                ," ).append("\n"); 
		query.append("      A.FUEL_SCG_AMT            ," ).append("\n"); 
		query.append("	  A.SCG_VAT_AMT             ," ).append("\n"); 
		query.append("      A.TOLL_FEE_AMT			," ).append("\n"); 
		query.append("      A.ETC_ADD_AMT             ," ).append("\n"); 
		query.append("      A.BKG_NO                  ," ).append("\n"); 
		query.append("      A.ORG_BKG_NO              ," ).append("\n"); 
		query.append("--      A.ORG_BKG_NO_SPLIT        ," ).append("\n"); 
		query.append("      A.TRSP_BND_CD             ," ).append("\n"); 
		query.append("      A.TRSP_COST_DTL_MOD_CD    ," ).append("\n"); 
		query.append("      TO_CHAR(A.LOCL_CRE_DT, 'YYYYMMDDHH24MISS') CRE_DT ," ).append("\n"); 
		query.append("      A.FM_NOD_CD               ," ).append("\n"); 
		query.append("      (SELECT NVL(V.PRNT_VNDR_SEQ, V.VNDR_SEQ)" ).append("\n"); 
		query.append("         FROM MDM_VENDOR V" ).append("\n"); 
		query.append("        WHERE V.VNDR_SEQ = A.VNDR_SEQ) VNDR_SEQ," ).append("\n"); 
		query.append("      A.CRE_OFC_CD              ," ).append("\n"); 
		query.append("      A.CRE_USR_ID" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD A" ).append("\n"); 
		query.append("WHERE A.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND   A.TRSP_SO_SEQ        = @[trsp_so_seq]" ).append("\n"); 
		query.append("AND   A.INV_NO IS NULL" ).append("\n"); 
		query.append("AND   A.DELT_FLG           = 'N'" ).append("\n"); 
		query.append("AND   A.TRSP_SO_STS_CD     = 'I'" ).append("\n"); 
		query.append("AND   A.HJL_NO IS NULL" ).append("\n"); 

	}
}