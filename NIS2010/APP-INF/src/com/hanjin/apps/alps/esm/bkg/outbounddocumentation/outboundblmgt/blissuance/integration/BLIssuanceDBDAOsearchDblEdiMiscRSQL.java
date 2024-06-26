/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiMiscRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.01
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchDblEdiMiscRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiMiscRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("samf",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_sender",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiMiscRSQL").append("\n"); 
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
		query.append("SELECT '{I_BKG_MISC' || CHR(10) ||" ).append("\n"); 
		query.append("       'IBM_PLANT_CD:' || NVL(FCTRY_CTNT, '') || CHR(10) ||" ).append("\n"); 
		query.append("       'IBM_PLANT_NM:' || NVL(FCTRY_NM, '') || CHR(10) ||" ).append("\n"); 
		query.append("       'IBM_DIV_CD:' || NVL(DIV_CTNT, '') || CHR(10) ||" ).append("\n"); 
		query.append("       'IBM_DIV_NM:' || NVL(DIV_NM, '') || CHR(10) ||" ).append("\n"); 
		query.append("       'IBM_BIZ_TP:' || NVL(BZTP_CTNT, ' ') || CHR(10) ||" ).append("\n"); 
		query.append("       'IBM_BIZ_NM:' || NVL(BIZ_NM, ' ') || CHR(10) ||" ).append("\n"); 
		query.append("       'IBM_TS_TP:' || NVL(TS_TP_CTNT, ' ') || CHR(10) ||" ).append("\n"); 
		query.append("       'IBM_TS_NM:' || NVL(TS_NM, ' ') || CHR(10) ||" ).append("\n"); 
		query.append("       'IBM_POL_ZIP_CD:' || NVL(POL_ZIP_ID, ' ') || CHR(10) ||" ).append("\n"); 
		query.append("       'IBM_POL_POST_CD:' || NVL(POL_PST_CTNT, ' ') || CHR(10) ||" ).append("\n"); 
		query.append("       'IBM_POD_ZIP_CD:' || NVL(POD_ZIP_ID, ' ') || CHR(10) ||" ).append("\n"); 
		query.append("       'IBM_POD_POST_CD:' || NVL(POD_PST_CTNT, ' ') || CHR(10) ||" ).append("\n"); 
		query.append("       'IBM_DEL_ZIP_CD:' || NVL(DEL_ZIP_ID, ' ') || CHR(10) ||" ).append("\n"); 
		query.append("       'IBM_DEL_POST_CD:' || NVL(DEL_PST_CTNT, ' ') || CHR(10) ||" ).append("\n"); 
		query.append("       'IBM_PAY_MTH:' || NVL(PAY_MZD_CTNT, ' ') || CHR(10) ||" ).append("\n"); 
		query.append("       'IBM_INV_DT:' || NVL(TO_CHAR(INV_DT,'YYYYMMDD'), ' ') || CHR(10) ||" ).append("\n"); 
		query.append("       'IBM_LINE_CHG_WGT:' || NVL(LINE_CHG_WGT, 0) || CHR(10) ||" ).append("\n"); 
		query.append("       'IBM_LINE_CHG_WGT_CD:' || NVL(LINE_CHG_WGT_UT_CD, ' ') || CHR(10) ||" ).append("\n"); 
		query.append("       'IBM_EDN_CHG_QTY:' || NVL(GDS_CHG_PCK_QTY, 0) || CHR(10) ||" ).append("\n"); 
		query.append("       'IBM_EDN_CHG_QTY_CD:' || NVL(GDS_CHG_PCK_TP_CTNT, ' ') || CHR(10) ||" ).append("\n"); 
		query.append("       'IBM_EDN_CHG_WGT:' || NVL(GDS_CHG_WGT, 0) || CHR(10) ||" ).append("\n"); 
		query.append("       'IBM_EDN_CHG_WGT_CD:' || NVL(GDS_CHG_WGT_UT_CD, ' ') || CHR(10) ||" ).append("\n"); 
		query.append("       'IBM_SUMCHG_WGT_QTY:' || NVL(TTL_CHG_WGT, 0) || CHR(10) ||" ).append("\n"); 
		query.append("       'IBM_SUMCHG_WGT_CD:' || NVL(TTL_CHG_WGT_UT_CD, ' ') || CHR(10) ||" ).append("\n"); 
		query.append("       'IBM_MESSAGE_NO:' || @[samf] || CHR(10) ||" ).append("\n"); 
		query.append("       '}I_BKG_MISC' || CHR(10)" ).append("\n"); 
		query.append("FROM   BKG_XTER_RQST_MISC" ).append("\n"); 
		query.append("WHERE  XTER_RQST_NO = @[ib_no]" ).append("\n"); 
		query.append("  AND  XTER_RQST_SEQ = @[ib_seq]" ).append("\n"); 
		query.append("  AND  XTER_SNDR_ID = @[edi_sender]" ).append("\n"); 

	}
}