/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CarrierRestrictionDBDAOGetImdgCrrRstrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.09.16 장강철
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

public class CarrierRestrictionDBDAOGetImdgCrrRstrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CarrierRestrictionDBDAOGetImdgCrrRstrRSQL(){
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
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.integration").append("\n"); 
		query.append("FileName : CarrierRestrictionDBDAOGetImdgCrrRstrRSQL").append("\n"); 
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
		query.append("SELECT   A.VSL_OPR_TP_CD               ," ).append("\n"); 
		query.append("A.IMDG_CRR_RSTR_SEQ           ," ).append("\n"); 
		query.append("A.IMDG_UN_NO                  ," ).append("\n"); 
		query.append("A.IMDG_UN_NO_SEQ              ," ).append("\n"); 
		query.append("A.IMDG_CLSS_CD                ," ).append("\n"); 
		query.append("(SELECT B.IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("FROM SCG_IMDG_UN_NO B" ).append("\n"); 
		query.append("WHERE A.IMDG_UN_NO = B.IMDG_UN_NO" ).append("\n"); 
		query.append("AND A.IMDG_UN_NO_SEQ = B.IMDG_UN_NO_SEQ)IMDG_COMP_GRP_CD," ).append("\n"); 
		query.append("A.IMDG_CRR_RSTR_EXPT_CD       ," ).append("\n"); 
		query.append("A.SLAN_CD                     ," ).append("\n"); 
		query.append("A.CRR_REGU_DESC               ," ).append("\n"); 
		query.append("A.CRE_USR_ID                  ," ).append("\n"); 
		query.append("A.CRE_DT                      ," ).append("\n"); 
		query.append("A.UPD_USR_ID" ).append("\n"); 
		query.append("FROM   SCG_IMDG_CRR_RSTR A" ).append("\n"); 
		query.append("WHERE   A.VSL_OPR_TP_CD = @[vsl_opr_tp_cd]" ).append("\n"); 
		query.append("#if (${imdg_clss_cd} != '')" ).append("\n"); 
		query.append("AND   A.IMDG_CLSS_CD  = @[imdg_clss_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${imdg_un_no_null} == 'Y' )" ).append("\n"); 
		query.append("AND   A.IMDG_UN_NO IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${imdg_un_no} != '')" ).append("\n"); 
		query.append("AND   A.IMDG_UN_NO  = @[imdg_un_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${imdg_un_no_seq} != '')" ).append("\n"); 
		query.append("AND   A.IMDG_UN_NO_SEQ  = @[imdg_un_no_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${imdg_crr_rstr_expt_cd} != '')" ).append("\n"); 
		query.append("AND   A.IMDG_CRR_RSTR_EXPT_CD  = @[imdg_crr_rstr_expt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${slan_cd} != '')" ).append("\n"); 
		query.append("AND   A.SLAN_CD  = @[slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}