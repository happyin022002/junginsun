/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOGetTariffRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.28
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.03.28 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOGetTariffRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회조건내, 최종 Version의 Tariff 가져오기
	  * =====================================================================
	  * 2011.03.28 진마리아 [선처리(SRM-201114694)] 사업계획 항비 로직 수정 요청
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOGetTariffRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("issue_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yard_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOGetTariffRSQL").append("\n"); 
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
		query.append("SELECT A.YD_CHG_NO					   YD_CHG_NO	" ).append("\n"); 
		query.append("      ,A.YD_CHG_VER_SEQ                YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("      ,TO_CHAR(A.EFF_DT, 'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(A.EXP_DT, 'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append("      ,A.CURR_CD" ).append("\n"); 
		query.append("      ,A.CPLS_FLG" ).append("\n"); 
		query.append("      ,A.LST_FLG" ).append("\n"); 
		query.append("	  ,A.UPD_USR_ID" ).append("\n"); 
		query.append("     ,TO_CHAR(A.UPD_DT, 'YYYY-MM-DD HH24:MI') UPD_DT" ).append("\n"); 
		query.append("      ,A.LGS_COST_CD COST_CD" ).append("\n"); 
		query.append("      ,A.VNDR_SEQ" ).append("\n"); 
		query.append("      ,B.ACCT_CD" ).append("\n"); 
		query.append("	  ,C.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM   PSO_YD_CHG     A" ).append("\n"); 
		query.append("	  , TES_LGS_COST  B" ).append("\n"); 
		query.append("	  ,MDM_VENDOR  C" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("AND    A.YD_CD = @[port_cd] || @[yard_cd]" ).append("\n"); 
		query.append("#if( ${flg} == 'ALL' )" ).append("\n"); 
		query.append("AND    A.CPLS_FLG = 'Y'" ).append("\n"); 
		query.append("#elseif( ${flg} == 'N' )" ).append("\n"); 
		query.append("AND    A.VNDR_SEQ IN(" ).append("\n"); 
		query.append(" 		#foreach($key IN ${vndr_seq}) " ).append("\n"); 
		query.append("         #if($velocityCount < $vndr_seq.size()) " ).append("\n"); 
		query.append("          '$key', " ).append("\n"); 
		query.append("         #else " ).append("\n"); 
		query.append("          '$key' " ).append("\n"); 
		query.append("         #end " ).append("\n"); 
		query.append("       	#end )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    A.LGS_COST_CD IN(" ).append("\n"); 
		query.append(" 		#foreach($key IN ${cost_cd}) " ).append("\n"); 
		query.append("         #if($velocityCount < $cost_cd.size()) " ).append("\n"); 
		query.append("          '$key', " ).append("\n"); 
		query.append("         #else " ).append("\n"); 
		query.append("          '$key' " ).append("\n"); 
		query.append("         #end " ).append("\n"); 
		query.append("       	#end )" ).append("\n"); 
		query.append("AND    TO_DATE(REPLACE(@[issue_date], '-', ''), 'YYYYMMDD') BETWEEN A.EFF_DT AND A.EXP_DT" ).append("\n"); 
		query.append("AND    A.LST_FLG = 'Y'" ).append("\n"); 
		query.append("AND    A.LGS_COST_CD = B.LGS_COST_CD" ).append("\n"); 
		query.append("AND	   A.VNDR_SEQ = C.VNDR_SEQ" ).append("\n"); 

	}
}