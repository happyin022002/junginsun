/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetOBVolBszRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.19
*@LastModifier : 김진주
*@LastVersion : 1.0
* 2010.01.19 김진주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim JinJoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOgetOBVolBszRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff 비용 계산을 위해 해당 O/B 의 Volume/Blocksize를 구한다.
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetOBVolBszRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration ").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOgetOBVolBszRSQL").append("\n"); 
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
		query.append("select ROUND(VOL / (NVL(LOA_LEN, 0) * NVL(VSL_WDT, 0) * NVL(SMR_DRFT_HGT, 0)), 4)" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT V.VSL_CD, NVL(       SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'LS',DECODE(S.CNTR_SIZE,'2',WEIGHT,0),0)))+" ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'LS',DECODE(S.CNTR_SIZE,'3',WEIGHT,0),0)))  +" ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'LS',DECODE(S.CNTR_SIZE,'4',WEIGHT,0),0)))  +" ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'LS',DECODE(S.CNTR_SIZE,'H',WEIGHT,0),0)))  +" ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'LS',DECODE(S.CNTR_SIZE,'L',WEIGHT,0),0)))  +" ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'2',WEIGHT,0),0)))  +" ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'3',WEIGHT,0),0)))  +" ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'4',WEIGHT,0),0)))  +" ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'H',WEIGHT,0),0)))  +" ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'L',WEIGHT,0),0)))  +" ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'LS',DECODE(S.CNTR_SIZE,'2',WEIGHT,0),0),0))  +" ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'LS',DECODE(S.CNTR_SIZE,'3',WEIGHT,0),0),0))  +" ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'LS',DECODE(S.CNTR_SIZE,'4',WEIGHT,0),0),0))  +" ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'LS',DECODE(S.CNTR_SIZE,'H',WEIGHT,0),0),0))  +" ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'LS',DECODE(S.CNTR_SIZE,'L',WEIGHT,0),0),0))  +" ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'2',WEIGHT,0),0),0))  +" ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'3',WEIGHT,0),0),0))  +" ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'4',WEIGHT,0),0),0))  +" ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'H',WEIGHT,0),0),0))  +" ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'L',WEIGHT,0),0),0))" ).append("\n"); 
		query.append(", 0 ) VOL" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V, TDR_HEADER H, TDR_SUMMARY S" ).append("\n"); 
		query.append("WHERE  V.VSL_CD       = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO   = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD   = substr(@[vvd], 9)" ).append("\n"); 
		query.append("AND    V.YD_CD        = @[yd_cd]" ).append("\n"); 
		query.append("AND    V.VSL_CD       = H.VSL_CD" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO   = H.VOY_NO" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD   = H.DIR_CD" ).append("\n"); 
		query.append("AND    V.VPS_PORT_CD  = H.PORT_CD" ).append("\n"); 
		query.append("AND    V.CLPT_IND_SEQ = H.CALL_IND" ).append("\n"); 
		query.append("AND    H.VSL_CD       = S.VSL_CD" ).append("\n"); 
		query.append("AND    H.VOY_NO       = S.VOY_NO" ).append("\n"); 
		query.append("AND    H.DIR_CD       = S.DIR_CD" ).append("\n"); 
		query.append("AND    H.PORT_CD      = S.PORT_CD" ).append("\n"); 
		query.append("AND    H.CALL_IND     = S.CALL_IND" ).append("\n"); 
		query.append("AND    S.STATUS       IN ('LS','LM')" ).append("\n"); 
		query.append("GROUP BY V.VSL_CD" ).append("\n"); 
		query.append(") A, MDM_VSL_CNTR M" ).append("\n"); 
		query.append("WHERE A.VSL_CD = M.VSL_CD" ).append("\n"); 

	}
}