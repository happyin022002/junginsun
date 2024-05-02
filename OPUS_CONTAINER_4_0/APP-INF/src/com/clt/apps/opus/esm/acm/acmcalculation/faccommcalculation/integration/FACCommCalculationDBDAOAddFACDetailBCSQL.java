/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FACCommCalculationDBDAOAddFACDetailBCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.05
*@LastModifier :
*@LastVersion : 1.0
* 2012.07.05
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmcalculation.faccommcalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FACCommCalculationDBDAOAddFACDetailBCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * FACCommCalculationDBDAOAddFACDetailBCSQL
	  * </pre>
	  */
	public FACCommCalculationDBDAOAddFACDetailBCSQL(){
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
		params.put("fac_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmcalculation.faccommcalculation.integration").append("\n");
		query.append("FileName : FACCommCalculationDBDAOAddFACDetailBCSQL").append("\n");
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
		query.append("INSERT INTO ACM_FAC_COMM_DTL" ).append("\n");
		query.append("(BKG_NO, SLS_OFC_CD, FAC_SEQ, CNTR_TPSZ_CD, BKG_VOL_QTY," ).append("\n");
		query.append("             IF_DTRB_AMT, CURR_CD, PAY_IF_DTRB_AMT, UPD_DT, UPD_USR_ID, CRE_DT, CRE_USR_ID)" ).append("\n");
		query.append("   SELECT A.BKG_NO, A.SLS_OFC_CD, A.FAC_SEQ, B.CNTR_TPSZ_CD, B.BKG_VOL_QTY," ).append("\n");
		query.append("            A.IF_AMT, 'USD', A.IF_AMT * OFT_RATIO, SYSDATE UPD_DT, 'COST' UPD_USR_ID, SYSDATE CRE_DT, 'COST' CRE_USR_ID" ).append("\n");
		query.append("     FROM (SELECT BKG_NO, SLS_OFC_CD, FAC_SEQ, IF_AMT" ).append("\n");
		query.append("             FROM ACM_FAC_COMM" ).append("\n");
		query.append("            WHERE BKG_NO = @[bkg_no] AND FAC_SEQ = @[fac_seq]) A," ).append("\n");
		query.append("          (SELECT " ).append("\n");
		query.append("                     BKG.BKG_NO, " ).append("\n");
		query.append("                     QTY.CNTR_TPSZ_CD, " ).append("\n");
		query.append("                     SUM (QTY.OP_CNTR_QTY) AS BKG_VOL_QTY," ).append("\n");
		query.append("                     RATIO_TO_REPORT (0) OVER (PARTITION BY BKG.BKG_NO) OFT_RATIO" ).append("\n");
		query.append("                FROM BKG_QUANTITY QTY, " ).append("\n");
		query.append("                     BKG_BL_DOC   DOC, " ).append("\n");
		query.append("                     BKG_BOOKING  BKG, " ).append("\n");
		query.append("                     BKG_BOOKING  BK2 " ).append("\n");
		query.append("               WHERE QTY.BKG_NO              = DOC.BKG_NO " ).append("\n");
		query.append("                 AND QTY.CNTR_TPSZ_CD NOT LIKE 'Q%' " ).append("\n");
		query.append("                 AND BK2.BKG_NO              = DOC.BKG_NO " ).append("\n");
		query.append("                 AND BK2.BL_NO_TP          <>  '9' " ).append("\n");
		query.append("                 AND BK2.BKG_STS_CD        <>  'X' " ).append("\n");
		query.append("                 AND " ).append("\n");
		query.append("                   ( " ).append("\n");
		query.append("                     BKG.BKG_NO              = DOC.BKG_NO " ).append("\n");
		query.append("                  OR BKG.BL_NO               = DOC.MST_CVRD_BL_NO " ).append("\n");
		query.append("                   ) " ).append("\n");
		query.append("                 AND BKG.BKG_NO              = @[bkg_no]" ).append("\n");
		query.append("            GROUP BY BKG.BKG_NO, " ).append("\n");
		query.append("                     QTY.CNTR_TPSZ_CD ) B" ).append("\n");
		query.append("    WHERE A.BKG_NO = B.BKG_NO" ).append("\n");

	}
}