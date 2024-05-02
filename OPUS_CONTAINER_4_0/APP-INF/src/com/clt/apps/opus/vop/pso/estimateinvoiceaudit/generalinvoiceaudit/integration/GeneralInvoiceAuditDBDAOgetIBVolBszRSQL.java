/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetIBVolBszRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.06
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOgetIBVolBszRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff 비용 계산을 위해 해당 I/B 의 Volume/Blocksize를 구한다.
	  * [2015.07.21]Virtual Add Calling 처리. VSK_VSL_PORT_SKD.NVL(VT_ADD_CALL_FLG, 'N') = 'N'
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetIBVolBszRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOgetIBVolBszRSQL").append("\n"); 
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
		query.append("SELECT ROUND(CASE WHEN (NVL(LOA_LEN, 0) * NVL(VSL_WDT, 0) * NVL(SMR_DRFT_HGT, 0)) <=0 THEN 0 ELSE VOL / (NVL(LOA_LEN, 0) * NVL(VSL_WDT, 0) * NVL(SMR_DRFT_HGT, 0)) END, 4)" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT A.VSL_CD, NVL(" ).append("\n"); 
		query.append("               SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'2',WEIGHT,0),0)))  + " ).append("\n"); 
		query.append("               SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'3',WEIGHT,0),0)))  + " ).append("\n"); 
		query.append("               SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'4',WEIGHT,0),0)))  + " ).append("\n"); 
		query.append("               SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'H',WEIGHT,0),0)))  + " ).append("\n"); 
		query.append("               SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'L',WEIGHT,0),0)))  + " ).append("\n"); 
		query.append("               SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'DT',DECODE(S.CNTR_SIZE,'2',WEIGHT,0),0)))  + " ).append("\n"); 
		query.append("               SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'DT',DECODE(S.CNTR_SIZE,'3',WEIGHT,0),0)))  + " ).append("\n"); 
		query.append("               SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'DT',DECODE(S.CNTR_SIZE,'4',WEIGHT,0),0)))  + " ).append("\n"); 
		query.append("               SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'DT',DECODE(S.CNTR_SIZE,'H',WEIGHT,0),0)))  +" ).append("\n"); 
		query.append("               SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'DT',DECODE(S.CNTR_SIZE,'L',WEIGHT,0),0)))  +" ).append("\n"); 
		query.append("               SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'2',WEIGHT,0),0),0))  +" ).append("\n"); 
		query.append("               SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'3',WEIGHT,0),0),0))  +" ).append("\n"); 
		query.append("               SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'4',WEIGHT,0),0),0))  +" ).append("\n"); 
		query.append("               SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'H',WEIGHT,0),0),0))  +" ).append("\n"); 
		query.append("               SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'L',WEIGHT,0),0),0))  +" ).append("\n"); 
		query.append("               SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'DT',DECODE(S.CNTR_SIZE,'2',WEIGHT,0),0),0))  +" ).append("\n"); 
		query.append("               SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'DT',DECODE(S.CNTR_SIZE,'3',WEIGHT,0),0),0))  +" ).append("\n"); 
		query.append("               SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'DT',DECODE(S.CNTR_SIZE,'4',WEIGHT,0),0),0))  +" ).append("\n"); 
		query.append("               SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'DT',DECODE(S.CNTR_SIZE,'H',WEIGHT,0),0),0))  +" ).append("\n"); 
		query.append("               SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'DT',DECODE(S.CNTR_SIZE,'L',WEIGHT,0),0),0)) " ).append("\n"); 
		query.append("               , 0 ) VOL " ).append("\n"); 
		query.append("         FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("            , TDR_HEADER H" ).append("\n"); 
		query.append("            , TDR_SUMMARY S" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("          AND A.VSL_CD         = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("          AND A.SKD_VOY_NO     = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("          AND A.SKD_DIR_CD     = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("          AND A.VPS_PORT_CD    = SUBSTR(@[yd_cd], 1, 5)" ).append("\n"); 
		query.append("          AND A.YD_CD          = @[yd_cd] /*2016.04.06 Add*/" ).append("\n"); 
		query.append("          AND A.CLPT_IND_SEQ   = @[clpt_ind_seq] /*2016.04.06 Add*/" ).append("\n"); 
		query.append("          AND NVL(A.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/ " ).append("\n"); 
		query.append("          AND A.VSL_CD       = H.VSL_CD" ).append("\n"); 
		query.append("          AND A.SKD_VOY_NO   = H.VOY_NO" ).append("\n"); 
		query.append("          AND A.SKD_DIR_CD   = H.DIR_CD" ).append("\n"); 
		query.append("          AND A.VPS_PORT_CD  = H.PORT_CD" ).append("\n"); 
		query.append("          AND A.CLPT_IND_SEQ = H.CALL_IND" ).append("\n"); 
		query.append("          AND H.VSL_CD       = S.VSL_CD" ).append("\n"); 
		query.append("          AND H.VOY_NO       = S.VOY_NO" ).append("\n"); 
		query.append("          AND H.DIR_CD       = S.DIR_CD" ).append("\n"); 
		query.append("          AND H.PORT_CD      = S.PORT_CD" ).append("\n"); 
		query.append("          AND H.CALL_IND     = S.CALL_IND" ).append("\n"); 
		query.append("          AND S.STATUS       IN ('DS','DT')" ).append("\n"); 
		query.append("        GROUP BY A.VSL_CD" ).append("\n"); 
		query.append("      ) A" ).append("\n"); 
		query.append("    , MDM_VSL_CNTR M" ).append("\n"); 
		query.append("WHERE A.VSL_CD = M.VSL_CD   " ).append("\n"); 

	}
}