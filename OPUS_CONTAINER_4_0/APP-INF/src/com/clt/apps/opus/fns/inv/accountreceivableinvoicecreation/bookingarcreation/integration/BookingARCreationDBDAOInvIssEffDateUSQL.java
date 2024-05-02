/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingARCreationDBDAOInvIssEffDateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.07
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2010.05.07 한동훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author donghoon han
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOInvIssEffDateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvIssEffDate
	  * </pre>
	  */
	public BookingARCreationDBDAOInvIssEffDateUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wrk_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOInvIssEffDateUSQL").append("\n"); 
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
		query.append("MERGE INTO INV_AR_AMT O" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("            select  DECODE( substr(replace(GL_EFF_DT,'-',''),1,6)||'01', new_eff_dt, replace(GL_EFF_DT,'-',''), new_eff_dt) EFF_DT, AR_IF_NO" ).append("\n"); 
		query.append("            from (        " ).append("\n"); 
		query.append("            select nvl(MAX(decode(gubn,'OFC', new_eff_dt,'')), " ).append("\n"); 
		query.append("                       nvl(MAX(decode(gubn,'RHQ', new_eff_dt,'')),'')) new_eff_dt,  AR_IF_NO, GL_EFF_DT     " ).append("\n"); 
		query.append("            from " ).append("\n"); 
		query.append("                 (  SELECT 'OFC' gubn, MIN(EFF_YRMON)||'01' as new_eff_dt, B.AR_IF_NO, B.GL_EFF_DT" ).append("\n"); 
		query.append("                    FROM   AP_PERIOD," ).append("\n"); 
		query.append("                    (SELECT V1.AR_IF_NO, V1.AR_OFC_CD, V1.GL_EFF_DT, V1.REV_TP_CD, V1.REV_SRC_CD " ).append("\n"); 
		query.append("                    FROM INV_AR_MN V1, INV_AR_ISS_FTR V2" ).append("\n"); 
		query.append("                    WHERE V1.AR_IF_NO = V2.AR_IF_NO " ).append("\n"); 
		query.append("                    AND V2.INV_ISS_WRK_NO = @[wrk_no]" ).append("\n"); 
		query.append("                    GROUP BY V1.AR_IF_NO, V1.AR_OFC_CD, V1.GL_EFF_DT, V1.REV_TP_CD, V1.REV_SRC_CD) B" ).append("\n"); 
		query.append("                    WHERE  SYS_DIV_CD = DECODE(B.REV_TP_CD,'B','10', 'C','10','M',decode(B.REV_SRC_CD, 'TH','11','33'),'X')" ).append("\n"); 
		query.append("                    AND    CLZ_STS_CD ='O'" ).append("\n"); 
		query.append("                    AND    OFC_CD = B.AR_OFC_CD" ).append("\n"); 
		query.append("                    AND    AR_AP_DIV_CD ='R'" ).append("\n"); 
		query.append("                    AND    EFF_YRMON >= substr( replace(B.GL_EFF_DT,'-',''),1,6)" ).append("\n"); 
		query.append("                    GROUP BY B.AR_IF_NO, B.GL_EFF_DT" ).append("\n"); 
		query.append("                    HAVING MIN(EFF_YRMON) IS NOT NULL " ).append("\n"); 
		query.append("                    Union all" ).append("\n"); 
		query.append("                   SELECT 'RHQ' gubn, MIN(EFF_YRMON)||'01' as new_eff_dt, B.AR_IF_NO, B.GL_EFF_DT" ).append("\n"); 
		query.append("                    FROM   AP_PERIOD," ).append("\n"); 
		query.append("                    (SELECT V1.AR_IF_NO, V1.AR_OFC_CD, V1.GL_EFF_DT, V1.REV_TP_CD, V1.REV_SRC_CD " ).append("\n"); 
		query.append("                    FROM INV_AR_MN V1, INV_AR_ISS_FTR V2" ).append("\n"); 
		query.append("                    WHERE V1.AR_IF_NO = V2.AR_IF_NO " ).append("\n"); 
		query.append("                    AND V2.INV_ISS_WRK_NO = @[wrk_no]" ).append("\n"); 
		query.append("                    GROUP BY V1.AR_IF_NO, V1.AR_OFC_CD, V1.GL_EFF_DT, V1.REV_TP_CD, V1.REV_SRC_CD) B" ).append("\n"); 
		query.append("                    WHERE  SYS_DIV_CD =DECODE(B.REV_TP_CD,'B','10', 'C','10','M',decode(B.REV_SRC_CD, 'TH','11','33'),'X')" ).append("\n"); 
		query.append("                    AND    CLZ_STS_CD ='O'" ).append("\n"); 
		query.append("                    AND    OFC_CD = (select AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                            from   MDM_ORGANIZATION" ).append("\n"); 
		query.append("                            where  ofc_cd = B.AR_OFC_CD)" ).append("\n"); 
		query.append("                    AND    AR_AP_DIV_CD ='R'" ).append("\n"); 
		query.append("                    AND    EFF_YRMON >= substr( replace(B.GL_EFF_DT,'-',''),1,6)" ).append("\n"); 
		query.append("                    GROUP BY B.AR_IF_NO, B.GL_EFF_DT" ).append("\n"); 
		query.append("                    HAVING MIN(EFF_YRMON) IS NOT NULL" ).append("\n"); 
		query.append("                ) GROUP BY AR_IF_NO, GL_EFF_DT" ).append("\n"); 
		query.append("            ) " ).append("\n"); 
		query.append("        )P" ).append("\n"); 
		query.append("ON (O.AR_IF_NO = P.AR_IF_NO)       " ).append("\n"); 
		query.append(" WHEN MATCHED THEN UPDATE SET O.ERP_IF_GL_DT = P.EFF_DT" ).append("\n"); 
		query.append("								,O.UPD_USR_ID = @[user_id]" ).append("\n"); 
		query.append("                                ,O.UPD_DT = SYSDATE" ).append("\n"); 

	}
}