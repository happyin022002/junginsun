/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLDocumentationBLDBDAOHblDtlInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.28
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.12.28 김영출
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Youngchul
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOHblDtlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLDocumentationBLDBDAOHblDtlInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOHblDtlInfoRSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("SELECT B.BKG_NO" ).append("\n"); 
		query.append(",      B.HBL_SEQ" ).append("\n"); 
		query.append(",      B.HBL_NO" ).append("\n"); 
		query.append(",      '' HBL_TTL_KNT" ).append("\n"); 
		query.append(",      B.CNTR_MF_NO" ).append("\n"); 
		query.append(",      B.ORG_CNTR_MF_NO" ).append("\n"); 
		query.append(",      B.BL_MK_DESC" ).append("\n"); 
		query.append(",      B.BL_GDS_DESC" ).append("\n"); 
		query.append(",      DECODE(B.PCK_QTY, '0', '', B.PCK_QTY) PCK_QTY" ).append("\n"); 
		query.append(",      B.PCK_TP_CD" ).append("\n"); 
		query.append(",      B.HBL_WGT" ).append("\n"); 
		query.append(",      NVL(B.WGT_UT_CD, (SELECT WGT_UT_CD FROM BKG_USR_DFLT_SET WHERE USR_ID=@[usr_id])) WGT_UT_CD" ).append("\n"); 
		query.append(",      B.CMDT_MEAS_QTY" ).append("\n"); 
		query.append(",      NVL(B.CMDT_MEAS_UT_CD, (SELECT MEAS_UT_CD FROM BKG_USR_DFLT_SET WHERE USR_ID=@[usr_id])) CMDT_MEAS_UT_CD" ).append("\n"); 
		query.append(",      B.HBL_MF_TP_CD" ).append("\n"); 
		query.append(",      B.IDA_IEC_NO" ).append("\n"); 
		query.append(",      (SELECT CUST_NM     FROM BKG_HBL_CUST_HIS WHERE BKG_NO=B.BKG_NO AND CORR_NO='TMP0000001' AND HBL_SEQ=B.HBL_SEQ AND BKG_CUST_TP_CD = 'S') SHPR_NM" ).append("\n"); 
		query.append(",      (SELECT CUST_ADDR   FROM BKG_HBL_CUST_HIS WHERE BKG_NO=B.BKG_NO AND CORR_NO='TMP0000001' AND HBL_SEQ=B.HBL_SEQ AND BKG_CUST_TP_CD = 'S') SHPR_ADDR" ).append("\n"); 
		query.append(",      (SELECT CTY_NM      FROM BKG_HBL_CUST_HIS WHERE BKG_NO=B.BKG_NO AND CORR_NO='TMP0000001' AND HBL_SEQ=B.HBL_SEQ AND BKG_CUST_TP_CD = 'S') SHPR_CTY_NM" ).append("\n"); 
		query.append(",      (SELECT STE_CD      FROM BKG_HBL_CUST_HIS WHERE BKG_NO=B.BKG_NO AND CORR_NO='TMP0000001' AND HBL_SEQ=B.HBL_SEQ AND BKG_CUST_TP_CD = 'S') SHPR_STE_CD" ).append("\n"); 
		query.append(",      (SELECT CUST_CNT_CD FROM BKG_HBL_CUST_HIS WHERE BKG_NO=B.BKG_NO AND CORR_NO='TMP0000001' AND HBL_SEQ=B.HBL_SEQ AND BKG_CUST_TP_CD = 'S') SHPR_CNT_CD" ).append("\n"); 
		query.append(",      (SELECT CUST_ZIP_ID FROM BKG_HBL_CUST_HIS WHERE BKG_NO=B.BKG_NO AND CORR_NO='TMP0000001' AND HBL_SEQ=B.HBL_SEQ AND BKG_CUST_TP_CD = 'S') SHPR_ZIP_CD" ).append("\n"); 
		query.append(",      (SELECT CUST_NM     FROM BKG_HBL_CUST_HIS WHERE BKG_NO=B.BKG_NO AND CORR_NO='TMP0000001' AND HBL_SEQ=B.HBL_SEQ AND BKG_CUST_TP_CD = 'C') CNEE_NM" ).append("\n"); 
		query.append(",      (SELECT CUST_ADDR   FROM BKG_HBL_CUST_HIS WHERE BKG_NO=B.BKG_NO AND CORR_NO='TMP0000001' AND HBL_SEQ=B.HBL_SEQ AND BKG_CUST_TP_CD = 'C') CNEE_ADDR" ).append("\n"); 
		query.append(",      (SELECT CTY_NM      FROM BKG_HBL_CUST_HIS WHERE BKG_NO=B.BKG_NO AND CORR_NO='TMP0000001' AND HBL_SEQ=B.HBL_SEQ AND BKG_CUST_TP_CD = 'C') CNEE_CTY_NM" ).append("\n"); 
		query.append(",      (SELECT STE_CD      FROM BKG_HBL_CUST_HIS WHERE BKG_NO=B.BKG_NO AND CORR_NO='TMP0000001' AND HBL_SEQ=B.HBL_SEQ AND BKG_CUST_TP_CD = 'C') CNEE_STE_CD" ).append("\n"); 
		query.append(",      (SELECT CUST_CNT_CD FROM BKG_HBL_CUST_HIS WHERE BKG_NO=B.BKG_NO AND CORR_NO='TMP0000001' AND HBL_SEQ=B.HBL_SEQ AND BKG_CUST_TP_CD = 'C') CNEE_CNT_CD" ).append("\n"); 
		query.append(",      (SELECT CUST_ZIP_ID FROM BKG_HBL_CUST_HIS WHERE BKG_NO=B.BKG_NO AND CORR_NO='TMP0000001' AND HBL_SEQ=B.HBL_SEQ AND BKG_CUST_TP_CD = 'C') CNEE_ZIP_CD" ).append("\n"); 
		query.append(",      (SELECT CUST_NM     FROM BKG_HBL_CUST_HIS WHERE BKG_NO=B.BKG_NO AND CORR_NO='TMP0000001' AND HBL_SEQ=B.HBL_SEQ AND BKG_CUST_TP_CD = 'N') NOTI_NM" ).append("\n"); 
		query.append(",      (SELECT CUST_ADDR   FROM BKG_HBL_CUST_HIS WHERE BKG_NO=B.BKG_NO AND CORR_NO='TMP0000001' AND HBL_SEQ=B.HBL_SEQ AND BKG_CUST_TP_CD = 'N') NOTI_ADDR" ).append("\n"); 
		query.append(",      (SELECT CTY_NM      FROM BKG_HBL_CUST_HIS WHERE BKG_NO=B.BKG_NO AND CORR_NO='TMP0000001' AND HBL_SEQ=B.HBL_SEQ AND BKG_CUST_TP_CD = 'N') NOTI_CTY_NM" ).append("\n"); 
		query.append(",      (SELECT STE_CD      FROM BKG_HBL_CUST_HIS WHERE BKG_NO=B.BKG_NO AND CORR_NO='TMP0000001' AND HBL_SEQ=B.HBL_SEQ AND BKG_CUST_TP_CD = 'N') NOTI_STE_CD" ).append("\n"); 
		query.append(",      (SELECT CUST_CNT_CD FROM BKG_HBL_CUST_HIS WHERE BKG_NO=B.BKG_NO AND CORR_NO='TMP0000001' AND HBL_SEQ=B.HBL_SEQ AND BKG_CUST_TP_CD = 'N') NOTI_CNT_CD" ).append("\n"); 
		query.append(",      (SELECT CUST_ZIP_ID FROM BKG_HBL_CUST_HIS WHERE BKG_NO=B.BKG_NO AND CORR_NO='TMP0000001' AND HBL_SEQ=B.HBL_SEQ AND BKG_CUST_TP_CD = 'N') NOTI_ZIP_CD" ).append("\n"); 
		query.append(",      B.CRE_USR_ID" ).append("\n"); 
		query.append(",      B.UPD_USR_ID" ).append("\n"); 
		query.append("FROM   BKG_HBL_HIS B" ).append("\n"); 
		query.append("WHERE  B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    B.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT B.BKG_NO" ).append("\n"); 
		query.append(",      B.HBL_SEQ" ).append("\n"); 
		query.append(",      B.HBL_NO" ).append("\n"); 
		query.append(",      '' HBL_TTL_KNT" ).append("\n"); 
		query.append(",      B.CNTR_MF_NO" ).append("\n"); 
		query.append(",      B.ORG_CNTR_MF_NO" ).append("\n"); 
		query.append(",      B.BL_MK_DESC" ).append("\n"); 
		query.append(",      B.BL_GDS_DESC" ).append("\n"); 
		query.append(",      DECODE(B.PCK_QTY, '0', '', B.PCK_QTY) PCK_QTY" ).append("\n"); 
		query.append(",      B.PCK_TP_CD" ).append("\n"); 
		query.append(",      B.HBL_WGT" ).append("\n"); 
		query.append(",      NVL(B.WGT_UT_CD, (SELECT WGT_UT_CD FROM BKG_USR_DFLT_SET WHERE USR_ID=@[usr_id])) WGT_UT_CD" ).append("\n"); 
		query.append(",      B.CMDT_MEAS_QTY" ).append("\n"); 
		query.append(",      NVL(B.CMDT_MEAS_UT_CD, (SELECT MEAS_UT_CD FROM BKG_USR_DFLT_SET WHERE USR_ID=@[usr_id])) CMDT_MEAS_UT_CD" ).append("\n"); 
		query.append(",      B.HBL_MF_TP_CD" ).append("\n"); 
		query.append(",      B.IDA_IEC_NO" ).append("\n"); 
		query.append(",      (SELECT CUST_NM     FROM BKG_HBL_CUST WHERE BKG_NO=B.BKG_NO AND HBL_SEQ=B.HBL_SEQ AND BKG_CUST_TP_CD = 'S') SHPR_NM" ).append("\n"); 
		query.append(",      (SELECT CUST_ADDR   FROM BKG_HBL_CUST WHERE BKG_NO=B.BKG_NO AND HBL_SEQ=B.HBL_SEQ AND BKG_CUST_TP_CD = 'S') SHPR_ADDR" ).append("\n"); 
		query.append(",      (SELECT CTY_NM      FROM BKG_HBL_CUST WHERE BKG_NO=B.BKG_NO AND HBL_SEQ=B.HBL_SEQ AND BKG_CUST_TP_CD = 'S') SHPR_CTY_NM" ).append("\n"); 
		query.append(",      (SELECT STE_CD      FROM BKG_HBL_CUST WHERE BKG_NO=B.BKG_NO AND HBL_SEQ=B.HBL_SEQ AND BKG_CUST_TP_CD = 'S') SHPR_STE_CD" ).append("\n"); 
		query.append(",      (SELECT CUST_CNT_CD FROM BKG_HBL_CUST WHERE BKG_NO=B.BKG_NO AND HBL_SEQ=B.HBL_SEQ AND BKG_CUST_TP_CD = 'S') SHPR_CNT_CD" ).append("\n"); 
		query.append(",      (SELECT CUST_ZIP_ID FROM BKG_HBL_CUST WHERE BKG_NO=B.BKG_NO AND HBL_SEQ=B.HBL_SEQ AND BKG_CUST_TP_CD = 'S') SHPR_ZIP_CD" ).append("\n"); 
		query.append(",      (SELECT CUST_NM     FROM BKG_HBL_CUST WHERE BKG_NO=B.BKG_NO AND HBL_SEQ=B.HBL_SEQ AND BKG_CUST_TP_CD = 'C') CNEE_NM" ).append("\n"); 
		query.append(",      (SELECT CUST_ADDR   FROM BKG_HBL_CUST WHERE BKG_NO=B.BKG_NO AND HBL_SEQ=B.HBL_SEQ AND BKG_CUST_TP_CD = 'C') CNEE_ADDR" ).append("\n"); 
		query.append(",      (SELECT CTY_NM      FROM BKG_HBL_CUST WHERE BKG_NO=B.BKG_NO AND HBL_SEQ=B.HBL_SEQ AND BKG_CUST_TP_CD = 'C') CNEE_CTY_NM" ).append("\n"); 
		query.append(",      (SELECT STE_CD      FROM BKG_HBL_CUST WHERE BKG_NO=B.BKG_NO AND HBL_SEQ=B.HBL_SEQ AND BKG_CUST_TP_CD = 'C') CNEE_STE_CD" ).append("\n"); 
		query.append(",      (SELECT CUST_CNT_CD FROM BKG_HBL_CUST WHERE BKG_NO=B.BKG_NO AND HBL_SEQ=B.HBL_SEQ AND BKG_CUST_TP_CD = 'C') CNEE_CNT_CD" ).append("\n"); 
		query.append(",      (SELECT CUST_ZIP_ID FROM BKG_HBL_CUST WHERE BKG_NO=B.BKG_NO AND HBL_SEQ=B.HBL_SEQ AND BKG_CUST_TP_CD = 'C') CNEE_ZIP_CD" ).append("\n"); 
		query.append(",      (SELECT CUST_NM     FROM BKG_HBL_CUST WHERE BKG_NO=B.BKG_NO AND HBL_SEQ=B.HBL_SEQ AND BKG_CUST_TP_CD = 'N') NOTI_NM" ).append("\n"); 
		query.append(",      (SELECT CUST_ADDR   FROM BKG_HBL_CUST WHERE BKG_NO=B.BKG_NO AND HBL_SEQ=B.HBL_SEQ AND BKG_CUST_TP_CD = 'N') NOTI_ADDR" ).append("\n"); 
		query.append(",      (SELECT CTY_NM      FROM BKG_HBL_CUST WHERE BKG_NO=B.BKG_NO AND HBL_SEQ=B.HBL_SEQ AND BKG_CUST_TP_CD = 'N') NOTI_CTY_NM" ).append("\n"); 
		query.append(",      (SELECT STE_CD      FROM BKG_HBL_CUST WHERE BKG_NO=B.BKG_NO AND HBL_SEQ=B.HBL_SEQ AND BKG_CUST_TP_CD = 'N') NOTI_STE_CD" ).append("\n"); 
		query.append(",      (SELECT CUST_CNT_CD FROM BKG_HBL_CUST WHERE BKG_NO=B.BKG_NO AND HBL_SEQ=B.HBL_SEQ AND BKG_CUST_TP_CD = 'N') NOTI_CNT_CD" ).append("\n"); 
		query.append(",      (SELECT CUST_ZIP_ID FROM BKG_HBL_CUST WHERE BKG_NO=B.BKG_NO AND HBL_SEQ=B.HBL_SEQ AND BKG_CUST_TP_CD = 'N') NOTI_ZIP_CD" ).append("\n"); 
		query.append(",      B.CRE_USR_ID" ).append("\n"); 
		query.append(",      B.UPD_USR_ID" ).append("\n"); 
		query.append("FROM   BKG_HBL B" ).append("\n"); 
		query.append("WHERE  B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}