/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchCustCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.26
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.26 
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

public class CargoReleaseOrderDBDAOsearchCustCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchCustCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_msg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_rcv_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchCustCodeRSQL").append("\n"); 
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
		query.append("SELECT MAX(CUST_CNT_CD) AS CUST_CNT_CD," ).append("\n"); 
		query.append("       MAX(CUST_SEQ) AS CUST_SEQ," ).append("\n"); 
		query.append("       MAX(CUST_CODE) AS CUST_CD," ).append("\n"); 
		query.append("       NVL(MAX(EDI_CNTR_SND_TP_CD),'B') AS EDI_BL_CNTR_IND," ).append("\n"); 
		query.append("       MAX(BKG_NO) AS BKG_NO" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT C.CUST_CNT_CD||LPAD(C.CUST_SEQ,6,0) AS CUST_CODE," ).append("\n"); 
		query.append("               D.EDI_CNTR_SND_TP_CD AS EDI_CNTR_SND_TP_CD," ).append("\n"); 
		query.append("               A.BKG_NO AS BKG_NO," ).append("\n"); 
		query.append("               C.CUST_CNT_CD AS CUST_CNT_CD," ).append("\n"); 
		query.append("               C.CUST_SEQ AS CUST_SEQ" ).append("\n"); 
		query.append("          FROM BKG_BOOKING      A," ).append("\n"); 
		query.append("               BKG_CUSTOMER     B," ).append("\n"); 
		query.append("               EDI_GRP_CUST     C," ).append("\n"); 
		query.append("               EDI_GRP_CGO      D" ).append("\n"); 
		query.append("         WHERE A.BL_NO          = @[bl_no]" ).append("\n"); 
		query.append("           AND A.BKG_NO         = B.BKG_NO" ).append("\n"); 
		query.append("           AND B.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("           AND (C.EDI_GRP_CD, C.CO_DIV_CD) IN (" ).append("\n"); 
		query.append("                                        SELECT DISTINCT EDI_GRP_CD, CO_DIV_CD" ).append("\n"); 
		query.append("                                          FROM EDI_GROUP" ).append("\n"); 
		query.append("                                         WHERE PROV_TRD_PRNR_ID = @[edi_snd_id]" ).append("\n"); 
		query.append("                                           AND CUST_TRD_PRNR_ID = @[edi_rcv_id]" ).append("\n"); 
		query.append("                                           AND DELT_FLG         = 'N')  " ).append("\n"); 
		query.append("           AND C.CUST_CNT_CD    = B.CUST_CNT_CD" ).append("\n"); 
		query.append("           AND C.CUST_SEQ       = B.CUST_SEQ" ).append("\n"); 
		query.append("           AND C.EDI_GRP_CD     = D.EDI_GRP_CD(+)" ).append("\n"); 
		query.append("           AND C.CO_DIV_CD      = D.CO_DIV_CD(+)" ).append("\n"); 
		query.append("           AND D.CUST_EDI_STS_CD = @[edi_msg_id]" ).append("\n"); 
		query.append("           AND ROWNUM           = 1    " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT ''," ).append("\n"); 
		query.append("               ''," ).append("\n"); 
		query.append("               BKG_NO," ).append("\n"); 
		query.append("               ''," ).append("\n"); 
		query.append("               0" ).append("\n"); 
		query.append("          FROM BKG_BOOKING" ).append("\n"); 
		query.append("         WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}