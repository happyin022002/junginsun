/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCQuotationMainDBDAORsltPriSqMnChkNeedCalcVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.15
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.04.15 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCQuotationMainDBDAORsltPriSqMnChkNeedCalcVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SCQuotationMainDBDAORsltPriSqMnChkNeedCalcVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.integration").append("\n"); 
		query.append("FileName : SCQuotationMainDBDAORsltPriSqMnChkNeedCalcVORSQL").append("\n"); 
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
		query.append("-- GENERAL이나 SPECIAL RATE에 데이터가 존재 하는데 CALCULATE 를 실행 하지 않은 데이터가 있는지 검사한다." ).append("\n"); 
		query.append("-- 이런 데이터가 존재시 COPY TO PROPOSAL을 하지 못한다." ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT   QTTN_NO, QTTN_VER_NO ,SVC_SCP_CD, GEN_SPCL_RT_TP_CD " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("          SELECT   MN.QTTN_NO,MN.QTTN_VER_NO ,MN.SVC_SCP_CD, 'G' AS GEN_SPCL_RT_TP_CD " ).append("\n"); 
		query.append("          FROM     PRI_SQ_MN MN" ).append("\n"); 
		query.append("          WHERE    MN.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("      		  AND  MN.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("			  AND  MN.PRS_GEN_RT_CMPB_CALC_FLG = 'N'" ).append("\n"); 
		query.append("			  AND  EXISTS (SELECT   1" ).append("\n"); 
		query.append("                           FROM     PRI_SQ_RT_CMDT_ROUT RT" ).append("\n"); 
		query.append("                           WHERE    RT.QTTN_NO        = MN.QTTN_NO" ).append("\n"); 
		query.append("                                AND RT.QTTN_VER_NO       = MN.QTTN_VER_NO " ).append("\n"); 
		query.append("                                AND GEN_SPCL_RT_TP_CD = 'G'" ).append("\n"); 
		query.append("                                AND ROWNUM = 1" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("          UNION ALL" ).append("\n"); 
		query.append("          SELECT   MN.QTTN_NO,MN.QTTN_VER_NO ,MN.SVC_SCP_CD, 'S' AS GEN_SPCL_RT_TP_CD " ).append("\n"); 
		query.append("          FROM     PRI_SQ_MN MN" ).append("\n"); 
		query.append("          WHERE    MN.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("      		  AND  MN.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("			  AND  MN.PRS_SPCL_RT_CMPB_CALC_FLG = 'N'" ).append("\n"); 
		query.append("			  AND  EXISTS (SELECT   1" ).append("\n"); 
		query.append("                           FROM     PRI_SQ_RT_CMDT_ROUT RT" ).append("\n"); 
		query.append("                           WHERE    RT.QTTN_NO        = MN.QTTN_NO" ).append("\n"); 
		query.append("                                AND RT.QTTN_VER_NO       = MN.QTTN_VER_NO " ).append("\n"); 
		query.append("                                AND MN.SVC_SCP_CD     = SVC_SCP_CD" ).append("\n"); 
		query.append("                                AND GEN_SPCL_RT_TP_CD = 'S'" ).append("\n"); 
		query.append("                                AND ROWNUM = 1" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY SVC_SCP_CD, GEN_SPCL_RT_TP_CD" ).append("\n"); 

	}
}