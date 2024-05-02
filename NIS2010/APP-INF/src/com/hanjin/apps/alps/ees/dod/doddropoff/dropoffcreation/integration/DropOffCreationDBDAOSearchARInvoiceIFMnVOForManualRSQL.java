/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DropOffCreationDBDAOSearchARInvoiceIFMnVOForManualRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DropOffCreationDBDAOSearchARInvoiceIFMnVOForManualRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AR 전송을 위한 Invoice Main Data를 읽어온다.
	  * </pre>
	  */
	public DropOffCreationDBDAOSearchARInvoiceIFMnVOForManualRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_ib_cfm_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_src_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.integration").append("\n"); 
		query.append("FileName : DropOffCreationDBDAOSearchARInvoiceIFMnVOForManualRSQL").append("\n"); 
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
		query.append("SELECT B.BL_NO," ).append("\n"); 
		query.append("       D.INV_SRC_NO," ).append("\n"); 
		query.append("	   B.BKG_NO," ).append("\n"); 
		query.append("       (SELECT A.AR_OFC_CD" ).append("\n"); 
		query.append("		  FROM MDM_ORGANIZATION A" ).append("\n"); 
		query.append("		 WHERE A.OFC_CD = @[tro_ib_cfm_ofc_cd]" ).append("\n"); 
		query.append("	   ) OFC_CD," ).append("\n"); 
		query.append("       CUST_CNT_CD," ).append("\n"); 
		query.append("       CUST_SEQ," ).append("\n"); 
		query.append("       B.BKG_OFC_CD OFC_CD," ).append("\n"); 
		query.append("       'DOD' IF_SRC_CD," ).append("\n"); 
		query.append("       B.VSL_CD," ).append("\n"); 
		query.append("       B.SKD_VOY_NO," ).append("\n"); 
		query.append("       B.SKD_DIR_CD," ).append("\n"); 
		query.append("       B.POL_CD," ).append("\n"); 
		query.append("       B.POD_CD," ).append("\n"); 
		query.append("       B.VSL_CD TRNK_VSL_CD," ).append("\n"); 
		query.append("       B.SKD_VOY_NO TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("       B.SKD_DIR_CD TRNK_SKD_DIR_CD," ).append("\n"); 
		query.append("       B.POR_CD," ).append("\n"); 
		query.append("       B.DEL_CD," ).append("\n"); 
		query.append("       DECODE(SUBSTR(D.CNTR_TPSZ_CD,2,1),'2',1,0) BKG_TEU_QTY," ).append("\n"); 
		query.append("       DECODE(SUBSTR(D.CNTR_TPSZ_CD,2,1),'2',0,1) BKG_FEU_QTY," ).append("\n"); 
		query.append("       'I' IO_BND_CD," ).append("\n"); 
		query.append("       (SELECT A.AR_OFC_CD" ).append("\n"); 
		query.append("		  FROM MDM_ORGANIZATION A" ).append("\n"); 
		query.append("		 WHERE A.OFC_CD = @[tro_ib_cfm_ofc_cd]" ).append("\n"); 
		query.append("	   ) SLS_OFC_CD," ).append("\n"); 
		query.append("       D.CRE_USR_ID," ).append("\n"); 
		query.append("       TO_CHAR(D.CRE_DT, 'yyyymmdd') AS CRE_DT," ).append("\n"); 
		query.append("       D.UPD_USR_ID," ).append("\n"); 
		query.append("       TO_CHAR(D.UPD_DT, 'yyyymmdd') AS UPD_DT," ).append("\n"); 
		query.append("       D.DRP_OFF_CUST_REF_RMK INV_REF_NO," ).append("\n"); 
		query.append("       D.DRP_OFF_XTER_RMK INV_RMK," ).append("\n"); 
		query.append("       B.DEST_TRNS_SVC_MOD_CD," ).append("\n"); 
		query.append("       '' CR_INV_NO" ).append("\n"); 
		query.append("  FROM BKG_BOOKING B," ).append("\n"); 
		query.append("	   BKG_CONTAINER C," ).append("\n"); 
		query.append("       DOD_DRP_OFF_CHG D" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("   AND B.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("   AND C.CNTR_NO = D.CNTR_NO" ).append("\n"); 
		query.append("   AND C.CNTR_TPSZ_CD = D.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("   AND D.DRP_OFF_CHG_SEQ = (SELECT MAX(G.DRP_OFF_CHG_SEQ)" ).append("\n"); 
		query.append("          					  FROM DOD_DRP_OFF_CHG G" ).append("\n"); 
		query.append("         					 WHERE G.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("           					   AND G.CNTR_NO = D.CNTR_NO) " ).append("\n"); 
		query.append("#if(${bkg_no} != '')" ).append("\n"); 
		query.append("   AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${inv_src_no} != '')" ).append("\n"); 
		query.append("   AND D.INV_SRC_NO = @[inv_src_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}