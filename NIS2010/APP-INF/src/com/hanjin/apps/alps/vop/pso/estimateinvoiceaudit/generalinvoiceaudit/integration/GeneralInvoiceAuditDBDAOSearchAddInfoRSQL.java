/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOSearchAddInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.05.31
*@LastModifier : 
*@LastVersion : 1.0
* 2017.05.31 
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

public class GeneralInvoiceAuditDBDAOSearchAddInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TUG BOAT를 사용하는 계정을 CHECK하기 위함.
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOSearchAddInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOSearchAddInfoRSQL").append("\n"); 
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
		query.append("SELECT DECODE(CNT,0,'N','Y') FLAG" ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append("SELECT COUNT(1) CNT" ).append("\n"); 
		query.append("FROM   PSO_YD_CHG X" ).append("\n"); 
		query.append("WHERE  X.LGS_COST_CD =  @[lgs_cost_cd]" ).append("\n"); 
		query.append("AND    X.YD_CD       =  @[yd_cd]" ).append("\n"); 
		query.append("AND    X.VNDR_SEQ    =  @[vndr_seq]" ).append("\n"); 
		query.append("AND    X.LST_FLG     =  'Y'" ).append("\n"); 
		query.append("AND    TO_DATE(@[iss_dt], 'YYYY-MM-DD') BETWEEN X.EFF_DT AND X.EXP_DT" ).append("\n"); 
		query.append("AND    EXISTS (  SELECT DISTINCT OBJ_LIST_NO " ).append("\n"); 
		query.append("                   FROM PSO_YD_CHG_XPR A, PSO_CHG_XPR_DTL B, PSO_FOML_DTL C" ).append("\n"); 
		query.append("                  WHERE A.YD_CHG_NO          = X.YD_CHG_NO" ).append("\n"); 
		query.append("                    AND A.YD_CHG_VER_SEQ     = X.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("                    AND A.CHG_XPR_NO         = B.CHG_XPR_NO" ).append("\n"); 
		query.append("                    AND B.FOML_NO            = C.FOML_NO" ).append("\n"); 
		query.append("                    AND C.PSO_FOML_DTL_TP_CD ='O'" ).append("\n"); 
		query.append("                    AND C.OBJ_LIST_NO        IN ('6','7','10','11') " ).append("\n"); 
		query.append("                UNION " ).append("\n"); 
		query.append("                 SELECT DISTINCT OBJ_LIST_NO FROM PSO_YD_CHG_XPR A, PSO_CHG_XPR_DTL B, PSO_COND_DTL C" ).append("\n"); 
		query.append("                  WHERE A.YD_CHG_NO          = X.YD_CHG_NO" ).append("\n"); 
		query.append("                    AND A.YD_CHG_VER_SEQ     = X.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("                    AND A.CHG_XPR_NO         = B.CHG_XPR_NO" ).append("\n"); 
		query.append("                    AND B.COND_NO            = C.COND_NO" ).append("\n"); 
		query.append("                    AND C.PSO_COND_DTL_TP_CD = 'O'" ).append("\n"); 
		query.append("                    AND C.OBJ_LIST_NO        IN ('6','7','10','11') ))" ).append("\n"); 

	}
}