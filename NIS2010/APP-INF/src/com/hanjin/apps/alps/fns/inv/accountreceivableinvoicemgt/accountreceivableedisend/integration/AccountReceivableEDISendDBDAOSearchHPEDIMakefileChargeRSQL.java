/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchHPEDIMakefileChargeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.26
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2011.01.26 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchHPEDIMakefileChargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchHPEDIMakefileChargeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchHPEDIMakefileChargeRSQL").append("\n"); 
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
		query.append("SELECT   C.CHG_CD AS CH_FCTYPE" ).append("\n"); 
		query.append("        ,C.TRF_RT_AMT AS CH_RATE" ).append("\n"); 
		query.append("        ,C.RAT_AS_CNTR_QTY AS CH_RATED_AS" ).append("\n"); 
		query.append("		,(SELECT ROUND(NVL(C.CHG_AMT*C.INV_XCH_RT,0),DP_PRCS_KNT) FROM MDM_CURRENCY WHERE CURR_CD = D.LOCL_CURR_CD) AS CH_BILL_CHARGE" ).append("\n"); 
		query.append("        ,C.CHG_AMT AS CH_RATE_CHARGE" ).append("\n"); 
		query.append("		,DECODE(C.CHG_CD ,'BUC',D.POL_CD||'_'||D.POD_CD||'_','BAF',D.POL_CD||'_'||D.POD_CD||'_','FRC',D.POL_CD||'_'||D.POD_CD||'_'" ).append("\n"); 
		query.append("						 ,'OTH',D.POL_CD||'_'||D.POD_CD||'_','ORC',D.POL_CD||'_'||D.POD_CD||'_'" ).append("\n"); 
		query.append("						 ,'MIS',D.POL_CD||'_'||D.POD_CD||'_','OTR',D.POL_CD||'_'||D.POD_CD||'_'" ).append("\n"); 
		query.append("						 ,'CAP',D.POL_CD||'_'||D.POD_CD||'_'" ).append("\n"); 
		query.append("						 ,'DDC',D.POL_CD||'_'||D.POD_CD||'_'" ).append("\n"); 
		query.append("						 ,'DIV',D.POL_CD||'_'||D.POD_CD||'_','ADF',D.POL_CD||'_'||D.POD_CD||'_','DVC',D.POL_CD||'_'||D.POD_CD||'_'" ).append("\n"); 
		query.append("						 ,'BCC',D.POL_CD||'_'||D.POD_CD||'_','BSF',D.POL_CD||'_'||D.POD_CD||'_','MCF',D.POL_CD||'_'||D.POD_CD||'_'" ).append("\n"); 
		query.append("						 ,'ERC',D.POL_CD||'_'||D.POD_CD||'_','EPS',D.POL_CD||'_'||D.POD_CD||'_'" ).append("\n"); 
		query.append("						 ,'DET',D.POL_CD||'_'||D.POD_CD||'_'" ).append("\n"); 
		query.append("						 ,'DMR',D.POL_CD||'_'||D.POD_CD||'_'" ).append("\n"); 
		query.append("						 ,'CLF',D.POL_CD||'_'||D.POD_CD||'_','SOC',D.POL_CD||'_'||D.POD_CD||'_'" ).append("\n"); 
		query.append("						 ,'WHC',D.POL_CD||'_'||D.POD_CD||'_','CFC',D.POL_CD||'_'||D.POD_CD||'_'" ).append("\n"); 
		query.append("						 ,'NSC',D.POL_CD||'_'||D.POD_CD||'_','OIH',D.POL_CD||'_'||D.POD_CD||'_'" ).append("\n"); 
		query.append("						 ,'DIH',D.POL_CD||'_'||D.POD_CD||'_','OFT','N','') AS CH_RATE_STRING" ).append("\n"); 
		query.append("        ,C.PER_TP_CD AS CH_PERTYPE" ).append("\n"); 
		query.append("        ,C.CURR_CD AS CH_CUR_CD" ).append("\n"); 
		query.append("        --,'VOLUME' AS CH_BL_RATED_QTY" ).append("\n"); 
		query.append("		,D.BKG_FEU_QTY+D.BKG_TEU_QTY AS CH_BL_RATED_QTY" ).append("\n"); 
		query.append("        ,'CN' AS CH_BL_RATED_QUAL" ).append("\n"); 
		query.append("        ,'10' AS CH_PERCENT" ).append("\n"); 
		query.append("        ,DECODE(D.IO_BND_CD,'O','P','I','C') AS CH_FRT_IND" ).append("\n"); 
		query.append("        ,D.LOCL_CURR_CD AS CH_BILL_CUR" ).append("\n"); 
		query.append("        ,TO_CHAR(C.INV_XCH_RT ,'FM999,990.0000') AS CH_EX_RATE    " ).append("\n"); 
		query.append("FROM  INV_AR_ISS A" ).append("\n"); 
		query.append("     ,INV_AR_ISS_DTL B" ).append("\n"); 
		query.append("     ,INV_AR_CHG C" ).append("\n"); 
		query.append("     ,INV_AR_MN D" ).append("\n"); 
		query.append("WHERE A.INV_NO = @[inv_no] --'HM1457061'" ).append("\n"); 
		query.append("  AND A.INV_SEQ  = 1" ).append("\n"); 
		query.append("  AND A.INV_NO  = B.INV_NO" ).append("\n"); 
		query.append("  AND B.AR_IF_NO = C.AR_IF_NO" ).append("\n"); 
		query.append("  AND B.CHG_SEQ = C.CHG_SEQ" ).append("\n"); 
		query.append("  AND B.AR_IF_NO = D.AR_IF_NO" ).append("\n"); 

	}
}