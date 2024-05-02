/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DODInvoiceMgtDBDAOSearchARInterfaceInvoiceMainRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.28
*@LastModifier : 
*@LastVersion : 1.0
* 2014.02.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DODInvoiceMgtDBDAOSearchARInterfaceInvoiceMainRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchARInterfaceInvoiceMain
	  * </pre>
	  */
	public DODInvoiceMgtDBDAOSearchARInterfaceInvoiceMainRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("dod_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration").append("\n"); 
		query.append("FileName : DODInvoiceMgtDBDAOSearchARInterfaceInvoiceMainRSQL").append("\n"); 
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
		query.append("SELECT  A.BL_NO" ).append("\n"); 
		query.append("      , A.BL_NO AS  BL_SRC_NO" ).append("\n"); 
		query.append("      , A.DOD_INV_NO AS INV_SRC_NO" ).append("\n"); 
		query.append("      , A.BKG_NO" ).append("\n"); 
		query.append("      , A.CUST_CNT_CD AS  CUST_CNT_CD" ).append("\n"); 
		query.append("      , A.CUST_SEQ AS CUST_SEQ" ).append("\n"); 
		query.append("      , (SELECT AR_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = A.CRE_OFC_CD)  AS OFC_CD" ).append("\n"); 
		query.append("      , 'EAS' AS IF_SRC_CD" ).append("\n"); 
		query.append("      , BK.VSL_CD " ).append("\n"); 
		query.append("      , BK.SKD_VOY_NO" ).append("\n"); 
		query.append("      , BK.SKD_DIR_CD" ).append("\n"); 
		query.append("      , BK.SVC_SCP_CD" ).append("\n"); 
		query.append("      , '' AS SAIL_DT" ).append("\n"); 
		query.append("      , '' AS SAIL_ARR_DT " ).append("\n"); 
		query.append("      , '' AS DUE_DT" ).append("\n"); 
		query.append("      , '' AS GL_EFF_DT" ).append("\n"); 
		query.append("      , BK.SLAN_CD" ).append("\n"); 
		query.append("	  , BK.POL_CD" ).append("\n"); 
		query.append("	  , A.POD_CD" ).append("\n"); 
		query.append("      , BK.POR_CD" ).append("\n"); 
		query.append("      , A.DEL_CD" ).append("\n"); 
		query.append("      , BK.T_VSL_CD AS TRNK_VSL_CD" ).append("\n"); 
		query.append("      , BK.T_SKD_VOY_NO  AS TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append("      , BK.T_SKD_DIR_CD  AS TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("      , (SELECT SUM(DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0)) FROM EAS_DOD_INV_DTL WHERE DOD_INV_NO = A.DOD_INV_NO) AS BKG_TEU_QTY" ).append("\n"); 
		query.append("      , (SELECT SUM(DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',0,1)) FROM EAS_DOD_INV_DTL WHERE DOD_INV_NO = A.DOD_INV_NO) AS BKG_FEU_QTY" ).append("\n"); 
		query.append("      , 'I' AS IO_BND_CD" ).append("\n"); 
		query.append("      , A.CRE_OFC_CD AS SLS_OFC_CD" ).append("\n"); 
		query.append("      , A.CRE_USR_ID" ).append("\n"); 
		query.append("      , A.CRE_OFC_CD" ).append("\n"); 
		query.append("	  , TO_CHAR(A.CRE_DT,'YYYYMMDD') AS CRE_DT" ).append("\n"); 
		query.append("      , @[cre_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      , @[ofc_cd] AS UPD_OFC_CD" ).append("\n"); 
		query.append("	  , TO_CHAR(A.UPD_DT,'YYYYMMDD') AS UPD_DT" ).append("\n"); 
		query.append("      , '' INV_REF_NO" ).append("\n"); 
		query.append("	  , '' AS INV_RMK" ).append("\n"); 
		query.append("	  , '' AS DEST_TRNS_SVC_MOD_CD" ).append("\n"); 
		query.append("      , A.AR_IF_FLG, A.DOD_INV_STS_CD " ).append("\n"); 
		query.append("FROM EAS_DOD_INV_MN A, " ).append("\n"); 
		query.append("     (SELECT B.BKG_NO, BV.VSL_CD , BV.SKD_VOY_NO ,BV.SKD_DIR_CD,  " ).append("\n"); 
		query.append("             B.VSL_CD  AS T_VSL_CD, B.SKD_VOY_NO AS T_SKD_VOY_NO ,B.SKD_DIR_CD  AS T_SKD_DIR_CD," ).append("\n"); 
		query.append("             B.SLAN_CD, B.IB_SLS_OFC_CD, B. SVC_SCP_CD, " ).append("\n"); 
		query.append("	         B.POL_CD,  B.POR_CD" ).append("\n"); 
		query.append("      FROM   BKG_VVD  BV" ).append("\n"); 
		query.append("            ,VSK_VSL_PORT_SKD ACT" ).append("\n"); 
		query.append("            ,BKG_BOOKING B" ).append("\n"); 
		query.append("      WHERE B.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("      AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("      AND BV.VSL_CD = ACT.VSL_CD " ).append("\n"); 
		query.append("      AND BV.SKD_VOY_NO = ACT.SKD_VOY_NO " ).append("\n"); 
		query.append("      AND BV.SKD_DIR_CD = ACT.SKD_DIR_CD " ).append("\n"); 
		query.append("      AND BV.POL_CD = ACT.VPS_PORT_CD " ).append("\n"); 
		query.append("      AND BV.POL_CLPT_IND_SEQ = ACT.CLPT_IND_SEQ " ).append("\n"); 
		query.append("      AND VPS_ETD_DT = (SELECT MAX(VPS_ETD_DT)" ).append("\n"); 
		query.append("                        FROM  BKG_VVD          BV" ).append("\n"); 
		query.append("                             ,VSK_VSL_PORT_SKD ACT" ).append("\n"); 
		query.append("                        WHERE  BV.VSL_CD = ACT.VSL_CD " ).append("\n"); 
		query.append("                        AND BV.SKD_VOY_NO = ACT.SKD_VOY_NO " ).append("\n"); 
		query.append("                        AND BV.SKD_DIR_CD = ACT.SKD_DIR_CD " ).append("\n"); 
		query.append("                        AND BV.POL_CD = ACT.VPS_PORT_CD " ).append("\n"); 
		query.append("                        AND BV.POL_CLPT_IND_SEQ = ACT.CLPT_IND_SEQ " ).append("\n"); 
		query.append("                        AND BV.BKG_NO =  @[bkg_no]) ) BK" ).append("\n"); 
		query.append("WHERE A.DOD_INV_NO = @[dod_inv_no]" ).append("\n"); 
		query.append("AND A.BKG_NO = BK.BKG_NO" ).append("\n"); 

	}
}