/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierRestrictionDBDAOScgImdgCrrRstrVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.dangerouscargorestriction.carrierrestriction.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierRestrictionDBDAOScgImdgCrrRstrVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public CarrierRestrictionDBDAOScgImdgCrrRstrVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.dangerouscargorestriction.carrierrestriction.integration").append("\n"); 
		query.append("FileName : CarrierRestrictionDBDAOScgImdgCrrRstrVORSQL").append("\n"); 
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
		query.append("SELECT  VSL_OPR_TP_CD," ).append("\n"); 
		query.append("             IMDG_CRR_RSTR_SEQ           ," ).append("\n"); 
		query.append("             IMDG_UN_NO                  ," ).append("\n"); 
		query.append("             IMDG_UN_NO_SEQ              ," ).append("\n"); 
		query.append("             IMDG_COMP_GRP_CD            ," ).append("\n"); 
		query.append("             IMDG_CRR_RSTR_EXPT_CD       ," ).append("\n"); 
		query.append("             SLAN_CD                     ," ).append("\n"); 
		query.append("             CRR_REGU_DESC               ," ).append("\n"); 
		query.append("             CRE_USR_ID                  ," ).append("\n"); 
		query.append("             CRE_DT                      ," ).append("\n"); 
		query.append("             UPD_USR_ID    				 ," ).append("\n"); 
		query.append("			 substr(xmlagg(xmlelement(a, DECODE(IMDG_CLSS_CD, '', '', ',') ||IMDG_CLSS_CD) order by IMDG_CLSS_CD).extract('//text()'), 2) IMDG_CLSS_CD" ).append("\n"); 
		query.append("  FROM  " ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                    SELECT   A.VSL_OPR_TP_CD," ).append("\n"); 
		query.append("                                 ''IMDG_CRR_RSTR_SEQ           ," ).append("\n"); 
		query.append("                                 ''IMDG_UN_NO                  ," ).append("\n"); 
		query.append("                                 ''IMDG_UN_NO_SEQ              ," ).append("\n"); 
		query.append("                                 'X'IMDG_CLSS_CD               ," ).append("\n"); 
		query.append("                                 ''IMDG_COMP_GRP_CD            ," ).append("\n"); 
		query.append("                                 ''IMDG_CRR_RSTR_EXPT_CD       ," ).append("\n"); 
		query.append("                                 ''SLAN_CD                     ," ).append("\n"); 
		query.append("                                 ''CRR_REGU_DESC               ," ).append("\n"); 
		query.append("                                 ''CRE_USR_ID                  ," ).append("\n"); 
		query.append("                                 ''CRE_DT                      ," ).append("\n"); 
		query.append("                                 ''UPD_USR_ID    " ).append("\n"); 
		query.append("                      FROM   SCG_IMDG_CRR_RSTR 	A" ).append("\n"); 
		query.append("							,MDM_CARRIER       	C" ).append("\n"); 
		query.append("                     WHERE   1 = 1" ).append("\n"); 
		query.append("					 AND	 A.VSL_OPR_TP_CD	= C.CRR_CD" ).append("\n"); 
		query.append("                    #if (${imdg_un_no} != '') " ).append("\n"); 
		query.append("                       AND   A.IMDG_UN_NO  = @[imdg_un_no]" ).append("\n"); 
		query.append("                       AND   A.IMDG_UN_NO_SEQ  = @[imdg_un_no_seq]" ).append("\n"); 
		query.append("                    #elseif (${imdg_clss_cd} != '') " ).append("\n"); 
		query.append("                       AND A.IMDG_CLSS_CD= @[imdg_clss_cd]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("                    SELECT   A.VSL_OPR_TP_CD," ).append("\n"); 
		query.append("                                 ''IMDG_CRR_RSTR_SEQ           ," ).append("\n"); 
		query.append("                                 ''IMDG_UN_NO                  ," ).append("\n"); 
		query.append("                                 ''IMDG_UN_NO_SEQ              ," ).append("\n"); 
		query.append("                                 'O' IMDG_CLSS_CD            ," ).append("\n"); 
		query.append("                                 ''IMDG_COMP_GRP_CD            ," ).append("\n"); 
		query.append("                                 ''IMDG_CRR_RSTR_EXPT_CD       ," ).append("\n"); 
		query.append("                                 ''SLAN_CD                     ," ).append("\n"); 
		query.append("                                 ''CRR_REGU_DESC               ," ).append("\n"); 
		query.append("                                 ''CRE_USR_ID                  ," ).append("\n"); 
		query.append("                                 ''CRE_DT                      ," ).append("\n"); 
		query.append("                                 ''UPD_USR_ID    " ).append("\n"); 
		query.append("                      FROM   SCG_IMDG_CRR_RSTR A" ).append("\n"); 
		query.append("							,MDM_CARRIER       	C" ).append("\n"); 
		query.append("                     WHERE   1 = 1" ).append("\n"); 
		query.append("					 AND	 A.VSL_OPR_TP_CD	= C.CRR_CD" ).append("\n"); 
		query.append("                    #if (${imdg_clss_cd} != '') " ).append("\n"); 
		query.append("                       AND A.IMDG_CLSS_CD= @[imdg_clss_cd]" ).append("\n"); 
		query.append("                       AND A.IMDG_UN_NO IS NULL" ).append("\n"); 
		query.append("                    #elseif (${imdg_un_no} != '') " ).append("\n"); 
		query.append("                       AND   A.IMDG_UN_NO  = @[imdg_un_no]" ).append("\n"); 
		query.append("                       AND   A.IMDG_UN_NO_SEQ  = @[imdg_un_no_seq]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("GROUP BY VSL_OPR_TP_CD," ).append("\n"); 
		query.append("             IMDG_CRR_RSTR_SEQ           ," ).append("\n"); 
		query.append("             IMDG_UN_NO                  ," ).append("\n"); 
		query.append("             IMDG_UN_NO_SEQ              ," ).append("\n"); 
		query.append("             IMDG_COMP_GRP_CD            ," ).append("\n"); 
		query.append("             IMDG_CRR_RSTR_EXPT_CD       ," ).append("\n"); 
		query.append("             SLAN_CD                     ," ).append("\n"); 
		query.append("             CRR_REGU_DESC               ," ).append("\n"); 
		query.append("             CRE_USR_ID                  ," ).append("\n"); 
		query.append("             CRE_DT                      ," ).append("\n"); 
		query.append("             UPD_USR_ID " ).append("\n"); 
		query.append("ORDER BY VSL_OPR_TP_CD" ).append("\n"); 

	}
}