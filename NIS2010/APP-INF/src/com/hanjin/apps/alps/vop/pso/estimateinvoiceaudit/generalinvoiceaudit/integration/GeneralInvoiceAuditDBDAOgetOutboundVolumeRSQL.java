/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetOutboundVolumeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOgetOutboundVolumeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff 비용 계산을 위해 해당 TDR 에서 ,Outbound Volume을 구한다.
	  * =====================================================================
	  * 2011.03.28 진마리아 [선처리(SRM-201114694)] 사업계획 항비 로직 수정 요청
	  * 2011.05.03 진마리아 CHM-201110100-01 Ocean Volume만 포함되도록 로직 수정
	  * 2014.03.07 SKY  CHM-201429128 Tariff simulation 로직 수정 - Inbound Volume / Out Bound Volume 계산
	  * - Outbound volume : Outbound cargo + T/S cargo + Inter port cargo + Interport T/S cargo ( full only) 
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetOutboundVolumeRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOgetOutboundVolumeRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("NVL(" ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LM', DECODE(CNTR_SIZE, '2', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, 0, QTY), 'R', DECODE(QTY, 0, 0, QTY), 0), 0), 0))     +     				" ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LM', DECODE(CNTR_SIZE, '3', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, 0, QTY), 'R', DECODE(QTY, 0, 0, QTY), 0), 0), 0))     +    				" ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LM', DECODE(CNTR_SIZE, '4', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, 0, QTY*2), 'R', DECODE(QTY, 0, 0, QTY*2), 0), 0), 0)) +     				" ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LM', DECODE(CNTR_SIZE, 'H', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, 0, QTY*2), 'R', DECODE(QTY, 0, 0, QTY*2), 0), 0), 0)) +    				" ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LM', DECODE(CNTR_SIZE, 'L', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, 0, QTY*2), 'R', DECODE(QTY, 0, 0, QTY*2), 0), 0), 0)) +     			" ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'OT', DECODE(CNTR_SIZE, '2', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, 0, QTY), 'R', DECODE(QTY, 0, 0, QTY), 0), 0), 0))     +    				" ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'OT', DECODE(CNTR_SIZE, '3', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, 0, QTY), 'R', DECODE(QTY, 0, 0, QTY), 0), 0), 0))     +   				" ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'OT', DECODE(CNTR_SIZE, '4', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, 0, QTY*2), 'R', DECODE(QTY, 0, 0, QTY*2), 0), 0), 0)) +   				" ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'OT', DECODE(CNTR_SIZE, 'H', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, 0, QTY*2), 'R', DECODE(QTY, 0, 0, QTY*2), 0), 0), 0)) + 				" ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'OT', DECODE(CNTR_SIZE, 'L', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, 0, QTY*2), 'R', DECODE(QTY, 0, 0, QTY*2), 0), 0), 0)) +" ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LI', DECODE(CNTR_SIZE, '2', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, 0, QTY), 'R', DECODE(QTY, 0, 0, QTY), 0), 0), 0))     +" ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LI', DECODE(CNTR_SIZE, '3', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, 0, QTY), 'R', DECODE(QTY, 0, 0, QTY), 0), 0), 0))     +" ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LI', DECODE(CNTR_SIZE, '4', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, 0, QTY*2), 'R', DECODE(QTY, 0, 0, QTY*2), 0), 0), 0)) +" ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LI', DECODE(CNTR_SIZE, 'H', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, 0, QTY*2), 'R', DECODE(QTY, 0, 0, QTY*2), 0), 0), 0)) +" ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LI', DECODE(CNTR_SIZE, 'L', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, 0, QTY*2), 'R', DECODE(QTY, 0, 0, QTY*2), 0), 0), 0)) +" ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LT', DECODE(CNTR_SIZE, '2', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, 0, QTY), 'R', DECODE(QTY, 0, 0, QTY), 0), 0), 0))     +" ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LT', DECODE(CNTR_SIZE, '3', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, 0, QTY), 'R', DECODE(QTY, 0, 0, QTY), 0), 0), 0))     +" ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LT', DECODE(CNTR_SIZE, '4', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, 0, QTY*2), 'R', DECODE(QTY, 0, 0, QTY*2), 0), 0), 0)) +" ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LT', DECODE(CNTR_SIZE, 'H', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, 0, QTY*2), 'R', DECODE(QTY, 0, 0, QTY*2), 0), 0), 0)) +" ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LT', DECODE(CNTR_SIZE, 'L', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, 0, QTY*2), 'R', DECODE(QTY, 0, 0, QTY*2), 0), 0), 0))      				" ).append("\n"); 
		query.append(", 0)" ).append("\n"); 
		query.append("#if (${budget_flag} == 'B') " ).append("\n"); 
		query.append("FROM   VSK_BUD_VSL_PORT_SKD V, TDR_HEADER H, TDR_SUMMARY S" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V, TDR_HEADER H, TDR_SUMMARY S" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE  V.VSL_CD = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD = substr(@[vvd], 9)" ).append("\n"); 
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
		query.append("AND    S.STATUS       IN ('LM','OT','LI','LT') -- Outbound cargo + T/S cargo + Inter port cargo + Interport T/S cargo ( full only)" ).append("\n"); 

	}
}