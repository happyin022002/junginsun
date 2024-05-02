/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RailInvoiceauditDBDAOModifyTrsRailInvDtlRailSoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailInvoiceauditDBDAOModifyTrsRailInvDtlRailSoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/O 테이블에 Invoice정보를 반영
	  * </pre>
	  */
	public RailInvoiceauditDBDAOModifyTrsRailInvDtlRailSoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("sOfcCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sUsrId",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.integration").append("\n"); 
		query.append("FileName : RailInvoiceauditDBDAOModifyTrsRailInvDtlRailSoUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_RAIL_BIL_ORD A" ).append("\n"); 
		query.append("   SET FINC_VSL_CD     = NVL((SELECT DISTINCT X.VSL_CD" ).append("\n"); 
		query.append("                               FROM AR_MST_REV_VVD X" ).append("\n"); 
		query.append("                              WHERE X.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("                                AND X.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                                AND X.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                AND X.SLAN_CD = A.SLAN_CD" ).append("\n"); 
		query.append("                                AND X.DELT_FLG = 'N')" ).append("\n"); 
		query.append("                            ,(SELECT VSL_CD FDR_VSL_CD FROM BKG_BOOKING WHERE BKG_NO = A.BKG_NO))" ).append("\n"); 
		query.append("      ,FINC_SKD_VOY_NO = NVL((SELECT DISTINCT X.SKD_VOY_NO" ).append("\n"); 
		query.append("                               FROM AR_MST_REV_VVD X" ).append("\n"); 
		query.append("                              WHERE X.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("                                AND X.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                                AND X.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                AND X.SLAN_CD = A.SLAN_CD" ).append("\n"); 
		query.append("                                AND X.DELT_FLG = 'N')" ).append("\n"); 
		query.append("                            ,(SELECT SKD_VOY_NO FDR_SKD_VOY_NO FROM BKG_BOOKING WHERE BKG_NO = A.BKG_NO))" ).append("\n"); 
		query.append("      ,FINC_SKD_DIR_CD = DECODE(SIGN((SELECT count(X.VSL_CD) - 1" ).append("\n"); 
		query.append("                                       FROM AR_MST_REV_VVD X" ).append("\n"); 
		query.append("                                      WHERE X.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("                                        AND X.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                                        AND X.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                        AND X.SLAN_CD = A.SLAN_CD" ).append("\n"); 
		query.append("                                        AND X.DELT_FLG = 'N'))" ).append("\n"); 
		query.append("                               ,-1" ).append("\n"); 
		query.append("                               ,(SELECT A.SKD_DIR_CD || NVL(COA_REV_DIR_CONV_FNC(VVD.SLAN_CD, VVD.POL_CD, VVD.SKD_DIR_CD), A.SKD_DIR_CD)" ).append("\n"); 
		query.append("                                  FROM BKG_VVD VVD" ).append("\n"); 
		query.append("                                 WHERE VVD.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                                   AND VVD.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("                                   AND ROWNUM = 1)" ).append("\n"); 
		query.append("                               ,0" ).append("\n"); 
		query.append("                               ,(SELECT A.SKD_DIR_CD || NVL(X.RLANE_DIR_CD, A.SKD_DIR_CD)" ).append("\n"); 
		query.append("                                  FROM AR_MST_REV_VVD X" ).append("\n"); 
		query.append("                                 WHERE X.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("                                   AND X.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                                   AND X.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                   AND X.SLAN_CD = A.SLAN_CD" ).append("\n"); 
		query.append("                                   AND X.DELT_FLG = 'N')" ).append("\n"); 
		query.append("                               ,1" ).append("\n"); 
		query.append("                               ,(SELECT A.SKD_DIR_CD || NVL(COA_REV_DIR_CONV_FNC(VVD.SLAN_CD, VVD.POL_CD, VVD.SKD_DIR_CD), A.SKD_DIR_CD)" ).append("\n"); 
		query.append("                                  FROM BKG_VVD VVD" ).append("\n"); 
		query.append("                                 WHERE VVD.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                                   AND VVD.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("                                   AND ROWNUM = 1))" ).append("\n"); 
		query.append("      ,UPD_USR_ID      = @[sUsrId]" ).append("\n"); 
		query.append("      ,LOCL_UPD_DT     = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[sOfcCd])" ).append("\n"); 
		query.append(" WHERE A.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND A.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 

	}
}