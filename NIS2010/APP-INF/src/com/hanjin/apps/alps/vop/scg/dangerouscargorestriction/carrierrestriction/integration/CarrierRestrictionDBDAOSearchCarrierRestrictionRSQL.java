/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CarrierRestrictionDBDAOSearchCarrierRestrictionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.14
*@LastModifier : 안진응
*@LastVersion : 1.0
* 2014.04.14 안진응
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author An Jin Eung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierRestrictionDBDAOSearchCarrierRestrictionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CarrierRestrictionDBDAOSearchCarrierRestrictionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_crr_rstr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_crr_rstr_expt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_opr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.integration").append("\n"); 
		query.append("FileName : CarrierRestrictionDBDAOSearchCarrierRestrictionRSQL").append("\n"); 
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
		query.append("SELECT  	Z.IMDG_TEK_NM_CHECK," ).append("\n"); 
		query.append("		Z.ROW_SEQ," ).append("\n"); 
		query.append("		Z.OPTCLASS," ).append("\n"); 
		query.append("		Z.VSL_OPR_TP_CD           ," ).append("\n"); 
		query.append("		Z.IMDG_CRR_RSTR_SEQ       ," ).append("\n"); 
		query.append("		Z.IMDG_UN_NO              ," ).append("\n"); 
		query.append("		Z.IMDG_UN_NO_SEQ          ," ).append("\n"); 
		query.append("		Z.IMDG_CLSS_CD            ," ).append("\n"); 
		query.append("		Z.IMDG_CLSS_CD_TXT," ).append("\n"); 
		query.append("		Z.IMDG_CRR_RSTR_EXPT_CD   ," ).append("\n"); 
		query.append("		Z.SLAN_CD                 ," ).append("\n"); 
		query.append("		Z.CRR_REGU_DESC           ," ).append("\n"); 
		query.append("		Z.CRE_USR_ID              ," ).append("\n"); 
		query.append("		Z.CRE_DT                  ," ).append("\n"); 
		query.append("		Z.UPD_USR_ID              ," ).append("\n"); 
		query.append("		Z.UPD_DT                  ," ).append("\n"); 
		query.append("		Z.IMDG_COMP_GRP_CD,Z.IMDG_CLSS_CD_DESC, Z.PRP_SHP_NM, " ).append("\n"); 
		query.append("CASE WHEN Z.IMDG_PCK_GRP_CD='1' THEN  'I' " ).append("\n"); 
		query.append("     WHEN Z.IMDG_PCK_GRP_CD='2' THEN  'II'" ).append("\n"); 
		query.append("     WHEN Z.IMDG_PCK_GRP_CD='3' THEN  'III'  END IMDG_PCK_GRP_CD," ).append("\n"); 
		query.append("         Z.IMDG_TEC_NM," ).append("\n"); 
		query.append("CASE WHEN" ).append("\n"); 
		query.append("    NVL(MAX(CASE  WHEN Z.RN = 1 THEN Z.IMDG_SUBS_RSK_LBL_CD  END),'')||" ).append("\n"); 
		query.append("    NVL(MAX(CASE  WHEN Z.RN = 2 THEN '/'||Z.IMDG_SUBS_RSK_LBL_CD  END),'')||" ).append("\n"); 
		query.append("    NVL(MAX(CASE  WHEN Z.RN = 3 THEN '/'||Z.IMDG_SUBS_RSK_LBL_CD  END),'')||" ).append("\n"); 
		query.append("    NVL(MAX(CASE  WHEN Z.RN = 4 THEN '/'||Z.IMDG_SUBS_RSK_LBL_CD  END),'') = '/' THEN ''" ).append("\n"); 
		query.append("     ELSE" ).append("\n"); 
		query.append("         NVL(MAX(CASE  WHEN Z.RN = 1 THEN Z.IMDG_SUBS_RSK_LBL_CD  END),'')||" ).append("\n"); 
		query.append("    NVL(MAX(CASE  WHEN Z.RN = 2 THEN '/'||Z.IMDG_SUBS_RSK_LBL_CD  END),'')||" ).append("\n"); 
		query.append("    NVL(MAX(CASE  WHEN Z.RN = 3 THEN '/'||Z.IMDG_SUBS_RSK_LBL_CD  END),'')||" ).append("\n"); 
		query.append("    NVL(MAX(CASE  WHEN Z.RN = 4 THEN '/'||Z.IMDG_SUBS_RSK_LBL_CD  END),'')  END" ).append("\n"); 
		query.append("    IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append(" FROM		(" ).append("\n"); 
		query.append("		SELECT  " ).append("\n"); 
		query.append("			'' IMDG_TEK_NM_CHECK," ).append("\n"); 
		query.append("			'' ROW_SEQ," ).append("\n"); 
		query.append("			'' OPTCLASS," ).append("\n"); 
		query.append("			A.VSL_OPR_TP_CD           ," ).append("\n"); 
		query.append("			A.IMDG_CRR_RSTR_SEQ       ," ).append("\n"); 
		query.append("			A.IMDG_UN_NO              ," ).append("\n"); 
		query.append("			A.IMDG_UN_NO_SEQ          ," ).append("\n"); 
		query.append("			A.IMDG_CLSS_CD            ," ).append("\n"); 
		query.append("		(SELECT S3.IMDG_CLSS_CD_DESC FROM SCG_IMDG_CLSS_CD S3" ).append("\n"); 
		query.append("		WHERE S3.IMDG_CLSS_CD= A.IMDG_CLSS_CD)IMDG_CLSS_CD_TXT," ).append("\n"); 
		query.append("			A.IMDG_CRR_RSTR_EXPT_CD   ," ).append("\n"); 
		query.append("			A.SLAN_CD                 ," ).append("\n"); 
		query.append("			A.CRR_REGU_DESC           ," ).append("\n"); 
		query.append("			A.CRE_USR_ID              ," ).append("\n"); 
		query.append("			A.CRE_DT                  ," ).append("\n"); 
		query.append("			A.UPD_USR_ID              ," ).append("\n"); 
		query.append("			A.UPD_DT                  ," ).append("\n"); 
		query.append("		     ( SELECT B.IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("		    FROM SCG_IMDG_UN_NO B" ).append("\n"); 
		query.append("		    WHERE A.IMDG_UN_NO = B.IMDG_UN_NO" ).append("\n"); 
		query.append("		      AND A.IMDG_UN_NO_SEQ = B.IMDG_UN_NO_SEQ)IMDG_COMP_GRP_CD," ).append("\n"); 
		query.append("			(SELECT S1.IMDG_CLSS_CD_DESC" ).append("\n"); 
		query.append("			   FROM SCG_IMDG_CLSS_CD S1 " ).append("\n"); 
		query.append("			  WHERE S1.IMDG_CLSS_CD = A.IMDG_CLSS_CD ) IMDG_CLSS_CD_DESC," ).append("\n"); 
		query.append("			(SELECT  B.PRP_SHP_NM FROM SCG_IMDG_UN_NO B " ).append("\n"); 
		query.append("			  WHERE  A.IMDG_UN_NO = B.IMDG_UN_NO " ).append("\n"); 
		query.append("			    AND  A.IMDG_UN_NO_SEQ = B.IMDG_UN_NO_SEQ)PRP_SHP_NM," ).append("\n"); 
		query.append("			(SELECT  B.IMDG_PCK_GRP_CD FROM SCG_IMDG_UN_NO B " ).append("\n"); 
		query.append("			  WHERE  A.IMDG_UN_NO = B.IMDG_UN_NO " ).append("\n"); 
		query.append("			    AND  A.IMDG_UN_NO_SEQ = B.IMDG_UN_NO_SEQ)IMDG_PCK_GRP_CD,            " ).append("\n"); 
		query.append("			(SELECT S1.IMDG_TEC_NM" ).append("\n"); 
		query.append("			   FROM SCG_IMDG_UN_NO_ORG_RACT S1 " ).append("\n"); 
		query.append("			  WHERE S1.IMDG_UN_NO = A.IMDG_UN_NO" ).append("\n"); 
		query.append("			    AND S1.IMDG_UN_NO_SEQ = A.IMDG_UN_NO_SEQ ) IMDG_TEC_NM " ).append("\n"); 
		query.append("                   ,B.IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("		  ,ROW_NUMBER()OVER(PARTITION BY B.IMDG_UN_NO,B.IMDG_UN_NO_SEQ ORDER BY  IMDG_SUBS_RSK_LBL_CD )RN    " ).append("\n"); 
		query.append("		FROM SCG_IMDG_CRR_RSTR A,SCG_IMDG_SUBS_RSK_LBL B" ).append("\n"); 
		query.append("		 WHERE " ).append("\n"); 
		query.append("		      A.IMDG_UN_NO     = B.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("		 AND   A.IMDG_UN_NO_SEQ = B.IMDG_UN_NO_SEQ(+)" ).append("\n"); 
		query.append("        #if (${crr_cd} != '')    " ).append("\n"); 
		query.append("		   AND   A.VSL_OPR_TP_CD  =  @[crr_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${imdg_clss_cd} != '')    " ).append("\n"); 
		query.append("		   AND   A.IMDG_CLSS_CD   =  @[imdg_clss_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${grp_cd} != '')    " ).append("\n"); 
		query.append("		   AND   A.IMDG_COMP_GRP_CD =  @[grp_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${imdg_un_no} != '')    " ).append("\n"); 
		query.append("		   AND   A.IMDG_UN_NO    =  @[imdg_un_no]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${imdg_un_no_seq} != '')    " ).append("\n"); 
		query.append("		   AND   A.IMDG_UN_NO_SEQ   =  @[imdg_un_no_seq]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${imdg_crr_rstr_expt_cd} != '')    " ).append("\n"); 
		query.append("		   AND   A.IMDG_CRR_RSTR_EXPT_CD  NOT IN (@[imdg_crr_rstr_expt_cd])" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		 " ).append("\n"); 
		query.append("		#if (${vsl_opr_tp_cd} != '' || ${imdg_crr_rstr_seq} != '')" ).append("\n"); 
		query.append("		  AND   A.VSL_OPR_TP_CD      = @[vsl_opr_tp_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${imdg_crr_rstr_seq} != '')" ).append("\n"); 
		query.append("		  AND   A.IMDG_CRR_RSTR_SEQ      = @[imdg_crr_rstr_seq]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${optclass} != '') " ).append("\n"); 
		query.append("		    #if(${optclass} == 'class') " ).append("\n"); 
		query.append("			AND   A.IMDG_UN_NO  IS NULL  /*class로 조회시*/" ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("		    #if(${optclass} == 'unno') " ).append("\n"); 
		query.append("			AND A.IMDG_UN_NO   IS NOT NULL   /*UNNO로 조회시*/" ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)Z" ).append("\n"); 
		query.append("GROUP BY	Z.IMDG_TEK_NM_CHECK," ).append("\n"); 
		query.append("		Z.ROW_SEQ," ).append("\n"); 
		query.append("		Z.OPTCLASS," ).append("\n"); 
		query.append("		Z.VSL_OPR_TP_CD           ," ).append("\n"); 
		query.append("		Z.IMDG_CRR_RSTR_SEQ       ," ).append("\n"); 
		query.append("		Z.IMDG_UN_NO              ," ).append("\n"); 
		query.append("		Z.IMDG_UN_NO_SEQ          ," ).append("\n"); 
		query.append("		Z.IMDG_CLSS_CD            ," ).append("\n"); 
		query.append("		Z.IMDG_CLSS_CD_TXT," ).append("\n"); 
		query.append("		Z.IMDG_CRR_RSTR_EXPT_CD   ," ).append("\n"); 
		query.append("		Z.SLAN_CD                 ," ).append("\n"); 
		query.append("		Z.CRR_REGU_DESC           ," ).append("\n"); 
		query.append("		Z.CRE_USR_ID              ," ).append("\n"); 
		query.append("		Z.CRE_DT                  ," ).append("\n"); 
		query.append("		Z.UPD_USR_ID              ," ).append("\n"); 
		query.append("		Z.UPD_DT                  ," ).append("\n"); 
		query.append("		Z.IMDG_COMP_GRP_CD,Z.IMDG_CLSS_CD_DESC, Z.PRP_SHP_NM, Z.IMDG_PCK_GRP_CD,Z.IMDG_TEC_NM" ).append("\n"); 
		query.append("ORDER BY Z.IMDG_CLSS_CD, Z.IMDG_UN_NO, Z.IMDG_UN_NO_SEQ," ).append("\n"); 
		query.append("         CASE WHEN Z.IMDG_CRR_RSTR_EXPT_CD = 'P' THEN  1" ).append("\n"); 
		query.append("              WHEN Z.IMDG_CRR_RSTR_EXPT_CD = 'R' THEN  2" ).append("\n"); 
		query.append("              WHEN Z.IMDG_CRR_RSTR_EXPT_CD = 'C' THEN  3              " ).append("\n"); 
		query.append("              WHEN Z.IMDG_CRR_RSTR_EXPT_CD = 'T' THEN  4" ).append("\n"); 
		query.append("              WHEN Z.IMDG_CRR_RSTR_EXPT_CD = 'L' THEN  5 END," ).append("\n"); 
		query.append("         Z.SLAN_CD" ).append("\n"); 

	}
}