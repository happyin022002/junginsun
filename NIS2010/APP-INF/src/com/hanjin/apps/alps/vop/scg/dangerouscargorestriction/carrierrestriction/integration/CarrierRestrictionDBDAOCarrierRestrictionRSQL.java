/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CarrierRestrictionDBDAOCarrierRestrictionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.09.23 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierRestrictionDBDAOCarrierRestrictionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CarrierRestrictionDBDAOCarrierRestrictionRSQL(){
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
		query.append("FileName : CarrierRestrictionDBDAOCarrierRestrictionRSQL").append("\n"); 
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
		query.append("SELECT  ''IMDG_SUBS_RSK_LBL_CD," ).append("\n"); 
		query.append("'' IMDG_TEK_NM_CHECK," ).append("\n"); 
		query.append("'' ROW_SEQ," ).append("\n"); 
		query.append("'' OPTCLASS," ).append("\n"); 
		query.append("''POL_VPS_PORT_CD," ).append("\n"); 
		query.append("''POD_VPS_PORT_CD," ).append("\n"); 
		query.append("'' IMDG_UN_NO_NULL," ).append("\n"); 
		query.append("''POL_PORT_CD," ).append("\n"); 
		query.append("''POD_PORT_CD   ," ).append("\n"); 
		query.append("A.VSL_OPR_TP_CD           ," ).append("\n"); 
		query.append("A.IMDG_CRR_RSTR_SEQ       ," ).append("\n"); 
		query.append("A.IMDG_UN_NO              ," ).append("\n"); 
		query.append("A.IMDG_UN_NO_SEQ          ," ).append("\n"); 
		query.append("A.IMDG_CLSS_CD            ," ).append("\n"); 
		query.append("(SELECT S3.IMDG_CLSS_CD_DESC FROM SCG_IMDG_CLSS_CD S3" ).append("\n"); 
		query.append("WHERE S3.IMDG_CLSS_CD= A.IMDG_CLSS_CD)IMDG_CLSS_CD_TXT," ).append("\n"); 
		query.append("A.IMDG_CRR_RSTR_EXPT_CD   ," ).append("\n"); 
		query.append("A.SLAN_CD                 ," ).append("\n"); 
		query.append("A.CRR_REGU_DESC           ," ).append("\n"); 
		query.append("A.CRE_USR_ID              ," ).append("\n"); 
		query.append("A.CRE_DT                  ," ).append("\n"); 
		query.append("A.UPD_USR_ID              ," ).append("\n"); 
		query.append("A.UPD_DT                  ," ).append("\n"); 
		query.append("''IMDG_COMP_GRP_CD," ).append("\n"); 
		query.append("(SELECT S1.IMDG_CLSS_CD_DESC" ).append("\n"); 
		query.append("FROM SCG_IMDG_CLSS_CD S1" ).append("\n"); 
		query.append("WHERE S1.IMDG_CLSS_CD = A.IMDG_CLSS_CD ) IMDG_CLSS_CD_DESC," ).append("\n"); 
		query.append("(SELECT  B.PRP_SHP_NM FROM SCG_IMDG_UN_NO B" ).append("\n"); 
		query.append("WHERE  A.IMDG_UN_NO = B.IMDG_UN_NO" ).append("\n"); 
		query.append("AND  A.IMDG_UN_NO_SEQ = B.IMDG_UN_NO_SEQ)PRP_SHP_NM," ).append("\n"); 
		query.append("(SELECT  B.IMDG_PCK_GRP_CD FROM SCG_IMDG_UN_NO B" ).append("\n"); 
		query.append("WHERE  A.IMDG_UN_NO = B.IMDG_UN_NO" ).append("\n"); 
		query.append("AND  A.IMDG_UN_NO_SEQ = B.IMDG_UN_NO_SEQ)IMDG_PCK_GRP_CD," ).append("\n"); 
		query.append("(SELECT S1.IMDG_TEC_NM" ).append("\n"); 
		query.append("FROM SCG_IMDG_UN_NO_ORG_RACT S1" ).append("\n"); 
		query.append("WHERE S1.IMDG_UN_NO = A.IMDG_UN_NO" ).append("\n"); 
		query.append("AND S1.IMDG_UN_NO_SEQ = A.IMDG_UN_NO_SEQ ) IMDG_TEC_NM" ).append("\n"); 
		query.append("FROM   SCG_IMDG_CRR_RSTR A" ).append("\n"); 
		query.append("WHERE   A.VSL_OPR_TP_CD  =  @[crr_cd]" ).append("\n"); 
		query.append("#if (${imdg_clss_cd} != '')" ).append("\n"); 
		query.append("AND   A.IMDG_CLSS_CD   =  @[imdg_clss_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${imdg_un_no} != '')" ).append("\n"); 
		query.append("AND   A.IMDG_UN_NO    =  @[imdg_un_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${imdg_un_no_seq} != '')" ).append("\n"); 
		query.append("AND   A.IMDG_UN_NO_SEQ   =  @[imdg_un_no_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${imdg_crr_rstr_expt_cd} != '')" ).append("\n"); 
		query.append("AND   A.IMDG_CRR_RSTR_EXPT_CD  NOT IN (@[imdg_crr_rstr_expt_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${imdg_tek_nm_check} == 'Y')" ).append("\n"); 
		query.append("AND  EXISTS (SELECT  'Y'" ).append("\n"); 
		query.append("FROM SCG_IMDG_UN_NO_ORG_RACT F" ).append("\n"); 
		query.append("WHERE F.IMDG_UN_NO     = A.IMDG_UN_NO" ).append("\n"); 
		query.append("AND F.IMDG_UN_NO_SEQ = A.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("AND F.IMDG_TEC_NM IS NOT NULL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_opr_tp_cd} != '' || ${imdg_crr_rstr_seq} != '')" ).append("\n"); 
		query.append("AND   A.VSL_OPR_TP_CD      = @[vsl_opr_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${imdg_crr_rstr_seq} != '')" ).append("\n"); 
		query.append("AND   A.IMDG_CRR_RSTR_SEQ      = @[imdg_crr_rstr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}